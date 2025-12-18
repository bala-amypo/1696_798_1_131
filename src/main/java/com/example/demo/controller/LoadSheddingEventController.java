package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.service.LoadSheddingEventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/load-shedding-event")
@Tag(name = "Load Shedding Event Controller")
public class LoadSheddingEventController {

    @Autowired
    private LoadSheddingEventService service;

    @Operation(summary = "Trigger load shedding event")
    @PostMapping("/trigger/{forecastId}")
    public LoadSheddingEvent trigger(@PathVariable Long forecastId) {
        return service.trigger(forecastId);
    }

    @Operation(summary = "Get event by ID")
    @GetMapping("/{id}")
    public Optional<LoadSheddingEvent> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "List events for zone")
    @GetMapping("/zone/{zoneId}")
    public List<LoadSheddingEvent> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }

    @Operation(summary = "List all events")
    @GetMapping("/")
    public List<LoadSheddingEvent> getAll() {
        return service.getAll();
    }
}
