package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "demand_readings")
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double demandValue;

    private LocalDateTime timestamp;   // exact name 'timestamp'

    private Long zoneId;               // exact name 'zoneId'

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getDemandValue() { return demandValue; }
    public void setDemandValue(Double demandValue) { this.demandValue = demandValue; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Long getZoneId() { return zoneId; }
    public void setZoneId(Long zoneId) { this.zoneId = zoneId; }
}