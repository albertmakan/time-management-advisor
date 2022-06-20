package com.sbnz.timemanagementadvisor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ActivityConflictException extends RuntimeException {
    public ActivityConflictException(String message) {
        super(message);
    }
}
