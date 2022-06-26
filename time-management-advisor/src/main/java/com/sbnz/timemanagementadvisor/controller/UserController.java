package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.User;
import com.sbnz.timemanagementadvisor.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getUser() {
        return userService.getUser().map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
