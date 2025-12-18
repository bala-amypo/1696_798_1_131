package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

@Entity
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin("0.0")
    private double availableSupplyMW;

    private Instant forecastStart;
    private Instant forecastEnd;
    private Instant generatedAt;

    public SupplyForecast() {
    }
    public void setId(Long id) {
    this.id = id;
}


    @PrePersist
    void onGenerate() {
        generatedAt = Instant.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public double getAvailableSupplyMW() { return availableSupplyMW; }
    public void setAvailableSupplyMW(double availableSupplyMW) { this.availableSupplyMW = availableSupplyMW; }
    public Instant getForecastStart() { return forecastStart; }
    public void setForecastStart(Instant forecastStart) { this.forecastStart = forecastStart; }
    public Instant getForecastEnd() { return forecastEnd; }
    public void setForecastEnd(Instant forecastEnd) { this.forecastEnd = forecastEnd; }
    public Instant getGeneratedAt() { return generatedAt; }
}
