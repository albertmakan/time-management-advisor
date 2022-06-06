package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.service.DayTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/day-template")
public class DayTemplateController {
    private final DayTemplateService dayTemplateService;
}
