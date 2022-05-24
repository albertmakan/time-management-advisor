package com.sbnz.timemanagementadvisor.controller;

import com.sbnz.timemanagementadvisor.model.User;
import com.sbnz.timemanagementadvisor.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> test() {
        User user = new User();
        user.setName("Albert");
        return new ResponseEntity<>(userService.classify(user), HttpStatus.OK);
    }
}
