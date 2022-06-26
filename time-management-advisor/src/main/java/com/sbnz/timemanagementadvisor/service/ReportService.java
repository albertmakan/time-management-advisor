package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.dto.ReportRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {
    private final DailyTimeSheetService dailyTimeSheetService;

    public List<?> getReport(ReportRequest reportRequest) {

        return new ArrayList<>();
    }
}
