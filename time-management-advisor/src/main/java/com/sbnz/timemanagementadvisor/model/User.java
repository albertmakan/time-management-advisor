package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Document
public class User {
    @Id @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String name;
    private Integer number;
    private LocalDate birthDate;
    private String email;
}
