package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.Activity;
import com.sbnz.timemanagementadvisor.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/activity", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/new")
    public ResponseEntity<Activity> create(@RequestBody Activity activity) {
        return new ResponseEntity<>(activityService.createNew(activity), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getAll() {
        return new ResponseEntity<>(activityService.getAll(), HttpStatus.OK);
    }
}
