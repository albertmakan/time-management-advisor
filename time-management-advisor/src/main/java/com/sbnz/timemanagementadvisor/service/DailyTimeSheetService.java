package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.model.Activity;
import com.sbnz.timemanagementadvisor.model.DailyTimeSheet;
import com.sbnz.timemanagementadvisor.model.User;
import com.sbnz.timemanagementadvisor.repository.DailyTimeSheetRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class DailyTimeSheetService {
    private final DailyTimeSheetRepository dailyTimeSheetRepository;
    private final DayTemplateService dayTemplateService;
    private final ActivityService activityService;
    private final UserService userService;
    private final KieContainer kieContainer;

    public Optional<DailyTimeSheet> findByDay(LocalDate day) {
        return dailyTimeSheetRepository.findByDay(day);
    }

    public List<DailyTimeSheet> getAll() {
        return dailyTimeSheetRepository.findAll();
    }

    public DailyTimeSheet planNextDay(LocalDate date) {
        KieSession kieSession = kieContainer.newKieSession("ksession-plan-day");

        LocalDate nd = LocalDate.now().plusDays(1);
        DailyTimeSheet day = findByDay(nd).orElse(new DailyTimeSheet(nd));
        day.getActivities().clear();

        dayTemplateService.getAll().forEach(kieSession::insert);
        activityService.getAllActive().forEach(kieSession::insert);

        kieSession.insert(day);

        kieSession.fireAllRules();
        kieSession.dispose();
        return dailyTimeSheetRepository.save(day);
    }

    public DailyTimeSheet evalThisDay(LocalDate date) {
        LocalDate nd = LocalDate.now();
        DailyTimeSheet day = findByDay(nd).orElse(new DailyTimeSheet(nd));
        if (day.getEvaluation() != null) return day;
        User user = userService.getUser().orElse(null);

        KieSession kieSession = kieContainer.newKieSession("ksession-eval-day");

        Map<ObjectId, Activity> activitiesToUpdate = new HashMap<>();
        kieSession.setGlobal("activitiesToUpdate", activitiesToUpdate);

        activityService.getAllActive().forEach(kieSession::insert);

        kieSession.insert(day);
        kieSession.insert(user);

        kieSession.fireAllRules();
        kieSession.dispose();

        activitiesToUpdate.forEach((id, a) -> activityService.save(a));

        return dailyTimeSheetRepository.save(day);
    }
}
