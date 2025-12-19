package com.example.demo.controller;

import com.example.demo.entity.DemandReading;
import com.example.demo.service.DemandReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand-readings")
public class DemandReadingController {

    private final DemandReadingService service;

    public DemandReadingController(DemandReadingService service) {
        this.service = service;
    }

    @PostMapping
    public DemandReading create(@RequestBody DemandReading reading) {
        return service.create(reading);
    }

    @GetMapping("/{id}")
    public DemandReading getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<DemandReading> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }
}
