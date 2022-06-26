package com.sbnz.timemanagementadvisor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.sbnz.timemanagementadvisor.model.enums.PostponementReason;
import lombok.Data;
import org.bson.types.ObjectId;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@Document
@Role(Role.Type.EVENT)
@Timestamp("dateTime")
public class Postponement {
    @Id @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private Date dateTime;
    private PostponementReason reason;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId activityId;
}
