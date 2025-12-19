package com.example.demo.controller;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.service.LoadSheddingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/load-shedding")
public class LoadSheddingController {

    private final LoadSheddingService service;

    public LoadSheddingController(LoadSheddingService service) {
        this.service = service;
    }

    @PostMapping("/{zoneId}")
    public LoadSheddingEvent create(
            @PathVariable Long zoneId,
            @RequestBody LoadSheddingEvent event) {
        return service.create(zoneId, event);
    }

    @GetMapping("/{id}")
    public LoadSheddingEvent getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<LoadSheddingEvent> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }
}
