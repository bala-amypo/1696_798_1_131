package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "zones", uniqueConstraints = @UniqueConstraint(columnNames = "zone_name"))
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_name", nullable = false, unique = true)
    @NotBlank
    private String zoneName;

    @Min(0)
    private int priorityLevel;

    @Min(0)
    private int population;

    private boolean active = true;

    private Instant createdAt;
    private Instant updatedAt;

    public Zone() {
    }
    public void setId(Long id) {
    this.id = id;
}


    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = Instant.now();
    }


    // Getters & Setters
    public Long getId() { return id; }
    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }
    public int getPriorityLevel() { return priorityLevel; }
    public void setPriorityLevel(int priorityLevel) { this.priorityLevel = priorityLevel; }
    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
