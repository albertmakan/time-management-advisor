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
@RequestMapping(value = "/api/monitoring", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonitoringController {
    private final MonitoringService monitoringService;

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        monitoringService.insertEvent();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
