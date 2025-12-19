package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repository;

    public DemandReadingServiceImpl(DemandReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public DemandReading create(DemandReading reading) {
        return repository.save(reading);
    }

    @Override
    public DemandReading getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DemandReading not found"));
    }

    @Override
    public List<DemandReading> getByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }
}
