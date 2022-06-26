package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.exceptions.BadRequestException;
import com.sbnz.timemanagementadvisor.model.AdviceMessage;
import com.sbnz.timemanagementadvisor.model.DayTemplate;
import com.sbnz.timemanagementadvisor.model.enums.MessageLevel;
import com.sbnz.timemanagementadvisor.repository.DayTemplateRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DayTemplateService {
    private final DayTemplateRepository dayTemplateRepository;
    private final KieContainer kieContainer;

    public List<DayTemplate> getAll() {
        return dayTemplateRepository.findAll();
    }

    public DayTemplate create(DayTemplate dayTemplate) {
        KieSession kieSession = kieContainer.newKieSession("ksession-routines");

        getAll().forEach(kieSession::insert);
        kieSession.insert(dayTemplate);
        AdviceMessage message = new AdviceMessage();
        kieSession.insert(message);

        kieSession.fireAllRules();
        kieSession.dispose();

        if (message.getLevel() == MessageLevel.ERROR) throw new BadRequestException(message.getText());
        if (message.getLevel() == MessageLevel.WARN) throw new BadRequestException(message.getText());

        return dayTemplateRepository.save(dayTemplate);
    }
}
