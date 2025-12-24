package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    // Default date-time format
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private DateTimeUtil() {
        // Private constructor to prevent object creation
    }

    /**
     * Get current date and time
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Get current date and time as formatted string
     */
    public static String nowAsString() {
        return format(LocalDateTime.now());
    }

    /**
     * Format LocalDateTime using default format
     */
    public static String format(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
        return dateTime.format(formatter);
    }

    /**
     * Format LocalDateTime using custom format
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * Convert LocalDateTime to system default zone
     */
    public static LocalDateTime convertToSystemZone(LocalDateTime dateTime) {
        return dateTime
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
