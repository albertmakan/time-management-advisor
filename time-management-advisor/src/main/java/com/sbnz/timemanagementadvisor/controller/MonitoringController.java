package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.service.MonitoringService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/monitoring")
public class MonitoringController {
    private final MonitoringService monitoringService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> test() {
        monitoringService.insertEvent();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
