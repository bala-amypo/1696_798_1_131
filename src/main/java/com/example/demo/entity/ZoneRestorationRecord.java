package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Zone zone;

    private Instant restoredAt;

    private Long eventId;

    private String notes;

    public ZoneRestorationRecord() {
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }
    public Instant getRestoredAt() { return restoredAt; }
    public void setRestoredAt(Instant restoredAt) { this.restoredAt = restoredAt; }
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
