package com.sbnz.timemanagementadvisor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class ReportDTO {
    private LocalDate day;
    private Set<String> titles;
    private Long duration;
}
