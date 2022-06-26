package com.sbnz.timemanagementadvisor.dto;

import com.sbnz.timemanagementadvisor.model.enums.ActivityType;
import lombok.Data;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class ReportRequest {
    @NotNull
    private LocalDate start, end;
    @NotNull
    private List<ObjectId> activityIds;
    @NotNull
    private List<ActivityType> activityTypes;
    private boolean byIds;
}
