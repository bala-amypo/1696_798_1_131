package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.DemandReadingService;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    @Override
    public void save() {
        // TODO: add business logic later
        System.out.println("DemandReadingService save() called");
    }
}