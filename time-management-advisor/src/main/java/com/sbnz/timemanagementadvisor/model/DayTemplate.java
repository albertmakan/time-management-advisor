package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
@Document
public class DayTemplate {
    @Id @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String name;
    private List<Routine> routines;
    private LocalTime activeStart, activeEnd;
    private Set<DayOfWeek> forDays;
}
