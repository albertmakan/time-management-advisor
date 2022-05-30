package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.sbnz.timemanagementadvisor.model.enums.ActivityContinuityType;
import com.sbnz.timemanagementadvisor.model.enums.ActivityType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Activity {
    @Id @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String title, description;
    private List<CheckListItem> checklist;
    private LocalDateTime start, end;
    private Duration estimatedTime;
    private Integer priority;
    private ActivityContinuityType continuityType;
    private ActivityType activityType;
    private Boolean isArchived=false, isDone=false;
    private PeriodicInfo periodicInfo;

    void a(){

    }

    @Data
    public static class PeriodicInfo {
        private List<DayOfWeek> forDays;
        private Integer nDays;
    }
}
