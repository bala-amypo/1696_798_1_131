package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/")
    public Zone create(@RequestBody Zone zone) {
        return zoneService.createZone(zone);
    }

    @PutMapping("/{id}")
    public Zone update(@PathVariable Long id, @RequestBody Zone zone) {
        return zoneService.updateZone(id, zone);
    }

    @GetMapping("/{id}")
    public Optional<Zone> getById(@PathVariable Long id) {
        return zoneService.getZoneById(id);
    }

    @GetMapping("/")
    public List<Zone> getAll() {
        return zoneService.getAllZones();
    }

    @PostMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        String result = zoneService.deactivateZone(id);
        return ResponseEntity.ok(result);
    }
}
