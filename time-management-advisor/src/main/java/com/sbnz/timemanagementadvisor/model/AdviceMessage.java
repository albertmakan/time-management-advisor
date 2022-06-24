package com.sbnz.timemanagementadvisor.model;

import com.sbnz.timemanagementadvisor.model.enums.MessageLevel;
import lombok.Data;

@Data
public class AdviceMessage {
    private String text;
    private MessageLevel level;
}
