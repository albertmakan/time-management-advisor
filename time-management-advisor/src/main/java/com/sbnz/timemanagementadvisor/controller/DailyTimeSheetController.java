package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.DailyTimeSheet;
import com.sbnz.timemanagementadvisor.service.DailyTimeSheetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/day")
public class DailyTimeSheetController {
    private final DailyTimeSheetService dailyTimeSheetService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyTimeSheet> test() {
        return new ResponseEntity<>(dailyTimeSheetService.planNextDay(), HttpStatus.OK);
    }
}
