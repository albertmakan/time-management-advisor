package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class DailyTimeSheet {
    @Id @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private LocalDate day;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId templateId;
    private List<ActivityInstance> activities;
    private String evaluation;

    public DailyTimeSheet(LocalDate day) {
        this.day = day;
        activities = new ArrayList<>();
    }

    void a(){
    }
}
