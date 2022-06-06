package com.sbnz.timemanagementadvisor.model;

import lombok.Data;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.util.Date;

@Data
@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class StopwatchEvent {
    private Date timestamp;

    public StopwatchEvent() {
        timestamp = new Date();
    }
}
