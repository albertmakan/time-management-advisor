package com.sbnz.timemanagementadvisor.model;

import com.sbnz.timemanagementadvisor.model.enums.ActivityType;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalTime;
import java.util.List;

@Data
public class ActivityInstance {
    private ObjectId activityId;
    private String title, description;
    private List<CheckListItem> checklist;
    private LocalTime beginning, end;
    private ActivityType activityType;
    private List<LocalTime> monitoring;
}
