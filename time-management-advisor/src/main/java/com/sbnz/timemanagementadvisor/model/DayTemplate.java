package com.sbnz.timemanagementadvisor.model;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;

@Data
public class DayTemplate {
    @Id
    private ObjectId id;
    private String name;
    private List<Routine> routines;
}
