package com.sbnz.timemanagementadvisor.model;

import com.sbnz.timemanagementadvisor.model.enums.ActivityContinuityType;
import com.sbnz.timemanagementadvisor.model.enums.ActivityType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Activity {
    private Long id;
    private String title, description;
    private List<String> checklist;
    private Date beginning, end;
    private Integer estimatedTimeMin;
    private Integer priority;
    private ActivityContinuityType continuityType;
    private ActivityType activityType;
    private Boolean isArchived, isDone;

}
