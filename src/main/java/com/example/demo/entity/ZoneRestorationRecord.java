package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "zone_restoration_records")
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_id", nullable = false)
    private Long zoneId;

    @Column(name = "restoration_details")
    private String restorationDetails;

    @Column(name = "restored_at")
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
