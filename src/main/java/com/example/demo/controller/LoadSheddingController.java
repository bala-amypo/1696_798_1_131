package com.example.demo.controller;

import com.example.demo.service.LoadSheddingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/load-shedding")
public class LoadSheddingController {

    private final LoadSheddingService service;

    public LoadSheddingController(LoadSheddingService service) {
        this.service = service;
    }

    // ✅ Tests expect BOOLEAN return
    @PostMapping("/trigger/{forecastId}")
    public boolean trigger(@PathVariable Long forecastId) {
        service.triggerLoadShedding(forecastId); // throws exception if no overload
        return true; // success case
    }
}
