package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.service.SupplyForecastService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/supply-forecasts")
@Tag(name = "Supply Forecast Controller")
public class SupplyForecastController {

    @Autowired
    private SupplyForecastService service;

    @Operation(summary = "Create forecast")
    @PostMapping("/")
    public SupplyForecast create(@RequestBody SupplyForecast forecast) {
        return service.save(forecast);
    }

    @Operation(summary = "Update forecast")
    @PutMapping("/{id}")
    public SupplyForecast update(@PathVariable Long id, @RequestBody SupplyForecast forecast) {
        forecast.setId(id);
        return service.save(forecast);
    }

    @Operation(summary = "Get forecast by ID")
    @GetMapping("/{id}")
    public Optional<SupplyForecast> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Get latest forecast")
    @GetMapping("/latest")
    public SupplyForecast getLatest() {
        return service.getLatest();
    }

    @Operation(summary = "List all forecasts")
    @GetMapping("/")
    public List<SupplyForecast> getAll() {
        return service.getAll();
    }
}
