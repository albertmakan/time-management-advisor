package com.sbnz.timemanagementadvisor.model.enums;

import com.sbnz.timemanagementadvisor.model.Routine;
import lombok.Data;

import java.util.List;

@Data
public class DayTemplate {
    List<Routine> routines;
}
