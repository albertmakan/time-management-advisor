package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.sbnz.timemanagementadvisor.model.enums.ActivityContinuityType;
import com.sbnz.timemanagementadvisor.model.enums.ActivityType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Document
public class Activity {
    @Id @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String title, description;
    private List<CheckListItem> checklist;
    @NotNull
    private LocalDateTime start;
    private LocalDateTime end;
    private Long estimatedTimeMinutes;
    private Integer priority;
    @NotNull
    private ActivityContinuityType continuityType;
    @NotNull
    private ActivityType activityType;
    private Boolean isArchived=false, isDone=false;

    private Set<DayOfWeek> forDays; // only if periodic

}
