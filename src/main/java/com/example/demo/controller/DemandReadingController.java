package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DemandReading;
import com.example.demo.service.DemandReadingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/demand-readings")
@Tag(name = "Demand Reading Controller")
public class DemandReadingController {

    @Autowired
    private DemandReadingService service;

    @Operation(summary = "Create demand reading")
    @PostMapping("/")
    public DemandReading create(@RequestBody DemandReading reading) {
        return service.save(reading);
    }

    @Operation(summary = "Get reading by ID")
    @GetMapping("/{id}")
    public Optional<DemandReading> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "List readings for zone")
    @GetMapping("/zone/{zoneId}")
    public List<DemandReading> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }

    @Operation(summary = "Get latest reading for zone")
    @GetMapping("/zone/{zoneId}/latest")
    public DemandReading getLatest(@PathVariable Long zoneId) {
        return service.getLatest(zoneId);
    }

    @Operation(summary = "Get recent readings for zone")
    @GetMapping("/zone/{zoneId}/recent")
    public List<DemandReading> getRecent(
            @PathVariable Long zoneId,
            @RequestParam int limit) {
        return service.getRecent(zoneId, limit);
    }
}
