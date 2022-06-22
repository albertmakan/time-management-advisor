package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.model.DayTemplate;
import com.sbnz.timemanagementadvisor.repository.DayTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DayTemplateService {
    private final DayTemplateRepository dayTemplateRepository;

    public List<DayTemplate> getAll() {
        return dayTemplateRepository.findAll();
    }
}
