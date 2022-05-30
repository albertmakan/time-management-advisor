package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.sbnz.timemanagementadvisor.model.enums.PostponementReason;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Document
public class Postponement {
    @Id @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private LocalDateTime dateTime;
    private PostponementReason reason;
    private ObjectId activityId;
}
