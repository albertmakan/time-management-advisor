package com.sbnz.timemanagementadvisor.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private Integer number;
    private Date birthDate;
    private String email;
}
