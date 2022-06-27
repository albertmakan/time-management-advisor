package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.exceptions.ConflictException;
import com.sbnz.timemanagementadvisor.exceptions.BadRequestException;
import com.sbnz.timemanagementadvisor.model.Activity;
import com.sbnz.timemanagementadvisor.model.AdviceMessage;
import com.sbnz.timemanagementadvisor.model.enums.MessageLevel;
import com.sbnz.timemanagementadvisor.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final KieContainer kieContainer;

    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    public List<Activity> getAllActive() {
        return activityRepository.findAllByIsArchivedFalseAndIsDoneFalse();
    }

    public List<Activity> getAllDone() {
        return activityRepository.findAllByIsDoneTrue();
    }

    public List<Activity> getAllArchived() {
        return activityRepository.findAllByIsArchivedTrue();
    }

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public Optional<Activity> getById(ObjectId id) {
        return activityRepository.findById(id);
    }

    public void archive(ObjectId id) {
        Activity a = getById(id).orElseThrow(()->new BadRequestException("Activity not found"));
        a.setIsArchived(true);
        save(a);
    }

    public void markDone(ObjectId id) {
        Activity a = getById(id).orElseThrow(()->new BadRequestException("Activity not found"));
        a.setIsDone(true);
        save(a);
    }

    public Activity createOrUpdate(Activity activity) {
        ObjectId id = activity.getId();
        activity.setId(null);
        KieSession kieSession = kieContainer.newKieSession("ksession-new-activity");
        kieSession.getAgenda().getAgendaGroup("constraints").setFocus();
        kieSession.insert(activity);
        AdviceMessage message = new AdviceMessage();
        kieSession.insert(message);
        kieSession.fireAllRules();
        if (message.getLevel() == MessageLevel.ERROR) throw new BadRequestException(message.getText());

        kieSession.getAgenda().getAgendaGroup("conflict").setFocus();

        List<Activity> activities = getAllActive();
        activities.removeIf(a -> a.getId().equals(id));
        activities.forEach(kieSession::insert);

        message = new AdviceMessage();
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();

        if (message.getLevel() == MessageLevel.ERROR) throw new BadRequestException(message.getText());
        if (message.getLevel() == MessageLevel.WARN) throw new ConflictException(message.getText());

        activity.setId(id);
        return save(activity);
    }
}
