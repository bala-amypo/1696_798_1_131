package com.example.demo.entity;

public class Zone {
    private Long id;
    private String zoneName;
    private int priorityLevel;
    private int population;
    private boolean active;

    // Constructors
    public Zone() {}

    public Zone(Long id, String zoneName, int priorityLevel, int population, boolean active) {
        this.id = id;
        this.zoneName = zoneName;
        this.priorityLevel = priorityLevel;
        this.population = population;
        this.active = active;
    }

    // Getters
    public Long getId() { return id; }
    public String getZoneName() { return zoneName; }
    public int getPriorityLevel() { return priorityLevel; }
    public int getPopulation() { return population; }
    public boolean isActive() { return active; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }
    public void setPriorityLevel(int priorityLevel) { this.priorityLevel = priorityLevel; }
    public void setPopulation(int population) { this.population = population; }
    public void setActive(boolean active) { this.active = active; }
}
