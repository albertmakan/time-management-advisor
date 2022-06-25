package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.DailyTimeSheet;
import com.sbnz.timemanagementadvisor.service.DailyTimeSheetService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping("/api/day")
public class DailyTimeSheetController {
    private final DailyTimeSheetService dailyTimeSheetService;

    @GetMapping(value = "/plan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyTimeSheet> plan() {
        return new ResponseEntity<>(dailyTimeSheetService.planNextDay(), HttpStatus.OK);
    }

    @GetMapping(value = "/eval", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyTimeSheet> eval() {
        return new ResponseEntity<>(dailyTimeSheetService.evalThisDay(), HttpStatus.OK);
    }

    @GetMapping(value = "/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyTimeSheet> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return new ResponseEntity<>(dailyTimeSheetService.findByDay(date)
                .orElse(new DailyTimeSheet(date)), HttpStatus.OK);
    }
}
