package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double availableSupplyMW;
    private Timestamp forecastStart;
    private Timestamp forecastEnd;

    private Timestamp generatedAt;

    @PrePersist
    public void onGenerate() {
        generatedAt = new Timestamp(System.currentTimeMillis());
    }
}
