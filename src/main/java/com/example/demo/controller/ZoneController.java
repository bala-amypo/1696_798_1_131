package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/zones")
@Tag(name = "Zone Controller")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @Operation(summary = "Create zone")
    @PostMapping("/")
    public Zone create(@RequestBody Zone zone) {
        return zoneService.save(zone);
    }

    @Operation(summary = "Update zone")
    @PutMapping("/{id}")
    public Zone update(@PathVariable Long id, @RequestBody Zone zone) {
        zone.setId(id);
        return zoneService.save(zone);
    }

    @Operation(summary = "Get zone by ID")
    @GetMapping("/{id}")
    public Optional<Zone> getById(@PathVariable Long id) {
        return zoneService.getById(id);
    }

    @Operation(summary = "List all zones")
    @GetMapping("/")
    public List<Zone> getAll() {
        return zoneService.getAll();
    }

    @Operation(summary = "Deactivate zone")
    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        return zoneService.deactivate(id);
    }
}
