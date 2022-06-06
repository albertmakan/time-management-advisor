package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/activity")
public class ActivityController {
    private final ActivityService activityService;
}
