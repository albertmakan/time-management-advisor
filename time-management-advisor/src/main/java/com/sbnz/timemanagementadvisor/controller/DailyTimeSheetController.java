package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.DailyTimeSheet;
import com.sbnz.timemanagementadvisor.service.DailyTimeSheetService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/day", produces = MediaType.APPLICATION_JSON_VALUE)
public class DailyTimeSheetController {
    private final DailyTimeSheetService dailyTimeSheetService;

    @PostMapping("/plan/{date}")
    public ResponseEntity<DailyTimeSheet> plan(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return new ResponseEntity<>(dailyTimeSheetService.planNextDay(date), HttpStatus.OK);
    }

    @PostMapping("/eval/{date}")
    public ResponseEntity<DailyTimeSheet> eval(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return new ResponseEntity<>(dailyTimeSheetService.evalThisDay(date), HttpStatus.OK);
    }

    @GetMapping("/{date}")
    public ResponseEntity<DailyTimeSheet> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return new ResponseEntity<>(dailyTimeSheetService.findByDay(date)
                .orElse(new DailyTimeSheet(date)), HttpStatus.OK);
    }
}
