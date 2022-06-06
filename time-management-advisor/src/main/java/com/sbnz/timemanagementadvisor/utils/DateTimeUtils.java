package com.sbnz.timemanagementadvisor.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeUtils {
    public static boolean isInNMinutes(LocalTime now, LocalTime start, int n) {
        return start.isBefore(now.plusMinutes(16)) && (start.isAfter(now) || start.equals(now));
    }

    public static boolean isInNMinutes(LocalDateTime now, LocalDateTime start, int n) {
        return start.isBefore(now.plusMinutes(16)) && (start.isAfter(now) || start.equals(now));
    }
}
