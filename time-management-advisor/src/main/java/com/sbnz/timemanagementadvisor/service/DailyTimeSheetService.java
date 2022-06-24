package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.model.DailyTimeSheet;
import com.sbnz.timemanagementadvisor.repository.ActivityRepository;
import com.sbnz.timemanagementadvisor.repository.DailyTimeSheetRepository;
import com.sbnz.timemanagementadvisor.repository.DayTemplateRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DailyTimeSheetService {
    private DailyTimeSheetRepository dailyTimeSheetRepository;
    private DayTemplateRepository dayTemplateRepository;
    private ActivityRepository activityRepository;
    private final KieContainer kieContainer;

    public Optional<DailyTimeSheet> findByDay(LocalDate day) {
        return dailyTimeSheetRepository.findByDay(day);
    }

    public DailyTimeSheet planNextDay() {
        KieSession kieSession = kieContainer.newKieSession("ksession-plan-day");

        LocalDate nd = LocalDate.now().plusDays(1);
        DailyTimeSheet day = findByDay(nd).orElse(new DailyTimeSheet(nd));
        day.getActivities().clear();

        dayTemplateRepository.findAll().forEach(kieSession::insert);
        activityRepository.findAllByIsArchivedFalseAndIsDoneFalse().forEach(kieSession::insert);

        kieSession.insert(day);

        kieSession.fireAllRules();
        kieSession.dispose();
        return dailyTimeSheetRepository.save(day);
    }
}
