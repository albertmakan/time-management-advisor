package com.sbnz.timemanagementadvisor.dto;

import com.sbnz.timemanagementadvisor.model.enums.ActivityType;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReportRequest {
    private LocalDate start, end;
    private List<ObjectId> activityIds;
    private List<ActivityType> activityTypes;
}
