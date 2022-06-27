package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.Activity;
import com.sbnz.timemanagementadvisor.service.ActivityService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/activity", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/new")
    public ResponseEntity<Activity> create(@RequestBody @Valid Activity activity) {
        return new ResponseEntity<>(activityService.createOrUpdate(activity), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Activity> edit(@RequestBody @Valid Activity activity) {
        return new ResponseEntity<>(activityService.createOrUpdate(activity), HttpStatus.OK);
    }

    @PutMapping("/archive/{id}")
    public ResponseEntity<Activity> archive(@PathVariable ObjectId id) {
        activityService.archive(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/mark-done/{id}")
    public ResponseEntity<Activity> markDone(@PathVariable ObjectId id) {
        activityService.markDone(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all/active")
    public ResponseEntity<List<Activity>> getAllActive() {
        return new ResponseEntity<>(activityService.getAllActive(), HttpStatus.OK);
    }

    @GetMapping("/all/archived")
    public ResponseEntity<List<Activity>> getAllArchived() {
        return new ResponseEntity<>(activityService.getAllArchived(), HttpStatus.OK);
    }

    @GetMapping("/all/done")
    public ResponseEntity<List<Activity>> getAllDone() {
        return new ResponseEntity<>(activityService.getAllDone(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getAll(@PathVariable ObjectId id) {
        return activityService.getById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
