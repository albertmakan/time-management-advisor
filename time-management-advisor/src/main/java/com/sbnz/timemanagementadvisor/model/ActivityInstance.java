package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.sbnz.timemanagementadvisor.model.enums.ActivityType;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalTime;
import java.util.List;

@Data
public class ActivityInstance {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId activityId;
    private String title, description;
    private List<CheckListItem> checklist;
    private LocalTime start, end;
    private ActivityType activityType;
    private List<LocalTime> monitoring;
}
