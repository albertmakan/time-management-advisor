package com.sbnz.timemanagementadvisor.model;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
public class DailyTimeSheet {
    @Id
    private ObjectId id;
    private LocalDate day;
    private ObjectId templateId;
    private List<ActivityInstance> activities;
    private String evaluation;

    void a(){

    }
}
