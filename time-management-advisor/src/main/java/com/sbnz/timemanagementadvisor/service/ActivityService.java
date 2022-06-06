package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;


}
