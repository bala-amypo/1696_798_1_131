package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restorations")
@Tag(name = "Zone Restoration Controller")
public class ZoneRestorationController {

    @Autowired
    private ZoneRestorationService service;

    @Operation(summary = "Restore zone")
    @PostMapping("/")
    public ZoneRestorationRecord restore(@RequestBody ZoneRestorationRecord record) {
        return service.save(record);
    }

    @Operation(summary = "Get restoration by ID")
    @GetMapping("/{id}")
    public Optional<ZoneRestorationRecord> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "List restorations for zone")
    @GetMapping("/zone/{zoneId}")
    public List<ZoneRestorationRecord> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }
}
