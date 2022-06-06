package com.sbnz.timemanagementadvisor.model;

import com.sbnz.timemanagementadvisor.model.enums.RoutineType;
import lombok.Data;

import java.time.LocalTime;

@Data
public class Routine {
    private String name;
    private RoutineType type;
    private LocalTime start, end;
}
