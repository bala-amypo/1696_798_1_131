package com.example.demo.controller;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.service.SupplyForecastService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supply-forecast")
public class SupplyForecastController {

    private final SupplyForecastService service;

    public SupplyForecastController(SupplyForecastService service) {
        this.service = service;
    }

    @PostMapping
    public SupplyForecast create(@RequestBody SupplyForecast forecast) {
        return service.create(forecast);
    }

    @PutMapping("/{id}")
    public SupplyForecast update(
            @PathVariable Long id,
            @RequestBody SupplyForecast forecast) {
        return service.update(id, forecast);
    }

    @GetMapping("/{id}")
    public SupplyForecast getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<SupplyForecast> getAll() {
        return service.getAll();
    }
}
