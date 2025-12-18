package com.example.demo.entity;

import java.sql.Timestamp;

public class DemandReading {
    private Long id;
    private Long zoneId;
    private int demandValue;
    private Timestamp recordedAt;

    // Constructors
    public DemandReading() {}

    public DemandReading(Long id, Long zoneId, int demandValue, Timestamp recordedAt) {
        this.id = id;
        this.zoneId = zoneId;
        this.demandValue = demandValue;
        this.recordedAt = recordedAt;
    }

    // Getters
    public Long getId() { return id; }
    public Long getZoneId() { return zoneId; }
    public int getDemandValue() { return demandValue; }
    public Timestamp getRecordedAt() { return recordedAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setZoneId(Long zoneId) { this.zoneId = zoneId; }
    public void setDemandValue(int demandValue) { this.demandValue = demandValue; }
    public void setRecordedAt(Timestamp recordedAt) { this.recordedAt = recordedAt; }
}
