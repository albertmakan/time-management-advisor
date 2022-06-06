package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.model.Activity;
import com.sbnz.timemanagementadvisor.model.DailyTimeSheet;
import com.sbnz.timemanagementadvisor.model.DayTemplate;
import com.sbnz.timemanagementadvisor.repository.ActivityRepository;
import com.sbnz.timemanagementadvisor.repository.DailyTimeSheetRepository;
import com.sbnz.timemanagementadvisor.repository.DayTemplateRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class DailyTimeSheetService {
    private DailyTimeSheetRepository dailyTimeSheetRepository;
    private DayTemplateRepository dayTemplateRepository;
    private ActivityRepository activityRepository;
    private final KieContainer kieContainer;

    public DailyTimeSheet planNextDay() {
        KieSession kieSession = kieContainer.newKieSession("ksession-plan-day");
        LocalDate nd = LocalDate.now().plusDays(1);
        DailyTimeSheet day = dailyTimeSheetRepository.findByDay(nd).orElse(new DailyTimeSheet(nd));
        day.getActivities().clear();

        List<DayTemplate> dayTemplates = dayTemplateRepository.findAll();
        List<Activity> activities = activityRepository.findAllByIsArchivedFalseAndIsDoneFalse();
        for (DayTemplate dt : dayTemplates) kieSession.insert(dt);
        for (Activity a : activities) kieSession.insert(a);

        kieSession.insert(day);

        kieSession.fireAllRules();
        kieSession.dispose();
        return dailyTimeSheetRepository.save(day);
    }
}
