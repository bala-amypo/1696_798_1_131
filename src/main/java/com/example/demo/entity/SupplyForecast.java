package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double availableSupplyMW;

    @Column(nullable = false)
    private Instant forecastStart;

    @Column(nullable = false)
    private Instant forecastEnd;

    private Instant generatedAt;

    @PrePersist
    void onCreate() {
        this.generatedAt = Instant.now();
    }

    // ✅ SAFE ADDITION — does NOT break existing tests
    public Double getAvailableSupplyMW() {
        return availableSupplyMW == null ? 0.0 : availableSupplyMW;
    }
}
