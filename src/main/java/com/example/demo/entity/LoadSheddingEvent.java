package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

@Entity
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Zone zone;

    private Instant eventStart;
    private Instant eventEnd;

    private String reason;

    private Long triggeredByForecastId;

    @DecimalMin("0.0")
    private double expectedDemandReductionMW;

    public LoadSheddingEvent() {
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }
    public Instant getEventStart() { return eventStart; }
    public void setEventStart(Instant eventStart) { this.eventStart = eventStart; }
    public Instant getEventEnd() { return eventEnd; }
    public void setEventEnd(Instant eventEnd) { this.eventEnd = eventEnd; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public Long getTriggeredByForecastId() { return triggeredByForecastId; }
    public void setTriggeredByForecastId(Long triggeredByForecastId) { this.triggeredByForecastId = triggeredByForecastId; }
    public double getExpectedDemandReductionMW() { return expectedDemandReductionMW; }
    public void setExpectedDemandReductionMW(double expectedDemandReductionMW) { this.expectedDemandReductionMW = expectedDemandReductionMW; }
}
