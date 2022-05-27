package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.User;
import com.sbnz.timemanagementadvisor.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> test(@RequestBody User user) {
        return new ResponseEntity<>(userService.classify(user), HttpStatus.OK);
    }
}
