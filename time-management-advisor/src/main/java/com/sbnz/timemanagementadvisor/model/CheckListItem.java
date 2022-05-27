package com.sbnz.timemanagementadvisor.model;

import lombok.Data;

@Data
public class CheckListItem {
    private String name;
    private Integer duration;
    private Boolean isDone;
}
