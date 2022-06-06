package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.repository.DayTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DayTemplateService {
    private final DayTemplateRepository dayTemplateRepository;


}
