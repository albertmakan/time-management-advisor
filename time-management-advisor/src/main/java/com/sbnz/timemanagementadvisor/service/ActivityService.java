package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.exceptions.ActivityConflictException;
import com.sbnz.timemanagementadvisor.exceptions.BadRequestException;
import com.sbnz.timemanagementadvisor.model.Activity;
import com.sbnz.timemanagementadvisor.model.AdviceMessage;
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

    public Activity createNew(Activity activity) {
        KieSession kieSession = kieContainer.newKieSession("ksession-new-activity");

        activityRepository.findAllByIsArchivedFalseAndIsDoneFalse().forEach(kieSession::insert);
        kieSession.insert(activity);
        AdviceMessage message = new AdviceMessage();
        kieSession.insert(message);

        kieSession.fireAllRules();
        kieSession.dispose();

        if (message.getText() != null)
            throw (message.isBadRequest()) ? new BadRequestException(message.getText()) :
                    new ActivityConflictException(message.getText());

        return activityRepository.save(activity);
    }
}
