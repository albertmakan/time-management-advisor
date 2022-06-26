package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.exceptions.ConflictException;
import com.sbnz.timemanagementadvisor.exceptions.BadRequestException;
import com.sbnz.timemanagementadvisor.model.Activity;
import com.sbnz.timemanagementadvisor.model.AdviceMessage;
import com.sbnz.timemanagementadvisor.model.enums.MessageLevel;
import com.sbnz.timemanagementadvisor.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity createNew(Activity activity) {
        KieSession kieSession = kieContainer.newKieSession("ksession-new-activity");
        kieSession.getAgenda().getAgendaGroup("constraints").setFocus();
        kieSession.insert(activity);
        AdviceMessage message = new AdviceMessage();
        kieSession.insert(message);
        kieSession.fireAllRules();
        if (message.getLevel() == MessageLevel.ERROR) throw new BadRequestException(message.getText());

        kieSession.getAgenda().getAgendaGroup("conflict").setFocus();
        getAllActive().forEach(kieSession::insert);
        message = new AdviceMessage();
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();

        if (message.getLevel() == MessageLevel.ERROR) throw new BadRequestException(message.getText());
        if (message.getLevel() == MessageLevel.WARN) throw new ConflictException(message.getText());

        return save(activity);
    }
}
