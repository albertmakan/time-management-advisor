package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
@Document
public class DayTemplate {
    @Id @JsonSerialize(using = ToStringSerializer.class) @Null
    private ObjectId id;
    @NotBlank
    private String name;
    @NotEmpty
    private List<Routine> routines;
    @NotNull
    private LocalTime activeStart, activeEnd;
    @NotNull
    private Set<DayOfWeek> forDays;
}
