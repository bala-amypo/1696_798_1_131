package com.example.demo.entity;

import java.sql.Timestamp;

public class ZoneRestorationRecord {
    private Long id;
    private Long zoneId;
    private String restorationDetails;
    private Timestamp restoredAt;

    // Constructors
    public ZoneRestorationRecord() {}

    public ZoneRestorationRecord(Long id, Long zoneId, String restorationDetails, Timestamp restoredAt) {
        this.id = id;
        this.zoneId = zoneId;
        this.restorationDetails = restorationDetails;
        this.restoredAt = restoredAt;
    }

    // Getters
    public Long getId() { return id; }
    public Long getZoneId() { return zoneId; }
    public String getRestorationDetails() { return restorationDetails; }
    public Timestamp getRestoredAt() { return restoredAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setZoneId(Long zoneId) { this.zoneId = zoneId; }
    public void setRestorationDetails(String restorationDetails) { this.restorationDetails = restorationDetails; }
    public void setRestoredAt(Timestamp restoredAt) { this.restoredAt = restoredAt; }
}
