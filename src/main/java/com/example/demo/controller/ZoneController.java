package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @PostMapping("/")
    public Zone create(@RequestBody Zone zone) {
        return zoneService.createZone(zone); // corrected
    }

    @PutMapping("/{id}")
    public Zone update(@PathVariable Long id, @RequestBody Zone zone) {
        return zoneService.updateZone(id, zone); // corrected
    }

    @GetMapping("/{id}")
    public Optional<Zone> getById(@PathVariable Long id) {
        return zoneService.getZoneById(id); // corrected
    }

    @GetMapping("/")
    public List<Zone> getAll() {
        return zoneService.getAllZones(); // corrected
    }

    @PostMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        return zoneService.deactivateZone(id); // corrected
    }
}
