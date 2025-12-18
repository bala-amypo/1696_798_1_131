package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    @Autowired
    private DemandReadingRepository repository;

    @Override
    public DemandReading save(DemandReading reading) {
        return repository.save(reading);
    }

    @Override
    public Optional<DemandReading> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DemandReading> getByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }

    @Override
    public DemandReading getLatest(Long zoneId) {
        return repository.findTopByZoneIdOrderByTimestampDesc(zoneId);
    }

    @Override
    public List<DemandReading> getRecent(Long zoneId, int limit) {
        return repository.findRecentByZone(zoneId, limit);
    }
}
