package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.DemandReadingService;

@RestController
public class DemandReadingController {

    @Autowired
    private DemandReadingService demandReadingService;

    @GetMapping("/demand")
    public String test() {
        return demandReadingService.getStatus();
    }
}
