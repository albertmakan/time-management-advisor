package com.sbnz.timemanagementadvisor.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeUtils {
    public static boolean isInNMinutes(LocalTime now, LocalTime start, int n) {
        return start.isBefore(now.plusMinutes(n)) && (start.isAfter(now) || start.equals(now));
    }

    public static boolean isInNMinutes(LocalDateTime now, LocalDateTime start, int n) {
        return start.isBefore(now.plusMinutes(n)) && (start.isAfter(now) || start.equals(now));
    }

    public static boolean isBetween(LocalTime time, LocalTime start, LocalTime end) {
        return !time.isBefore(start) && !time.isAfter(end);
    }

    public static boolean isBetween(LocalDateTime time, LocalDateTime start, LocalDateTime end) {
        return !time.isBefore(start) && !time.isAfter(end);
    }

    public static boolean isOverlapping(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

    public static boolean isOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return (end2==null || start1.isBefore(end2)) && (end1==null || start2.isBefore(end1));
    }
}
