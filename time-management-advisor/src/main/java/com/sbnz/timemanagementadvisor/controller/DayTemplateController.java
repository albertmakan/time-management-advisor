package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.DayTemplate;
import com.sbnz.timemanagementadvisor.service.DayTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/day-template")
public class DayTemplateController {
    private final DayTemplateService dayTemplateService;

    @GetMapping("/all")
    public ResponseEntity<List<DayTemplate>> getAll() {
        return new ResponseEntity<>(dayTemplateService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<DayTemplate> create(@RequestBody @Valid DayTemplate dayTemplate) {
        return new ResponseEntity<>(dayTemplateService.create(dayTemplate), HttpStatus.OK);
    }
}
