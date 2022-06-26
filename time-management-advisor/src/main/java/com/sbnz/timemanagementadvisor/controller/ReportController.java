package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.dto.ReportDTO;
import com.sbnz.timemanagementadvisor.dto.ReportRequest;
import com.sbnz.timemanagementadvisor.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<List<ReportDTO>> getReport(@RequestBody ReportRequest reportRequest) {
        return new ResponseEntity<>(reportService.getReport(reportRequest), HttpStatus.OK);
    }
}
