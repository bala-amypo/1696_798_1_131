package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    @Autowired
    private DemandReadingRepository repo;

    @Override
    public DemandReading save(DemandReading reading) {
        return repo.save(reading);
    }

    @Override
    public DemandReading getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public DemandReading getByZone(Long zoneId) {
        return repo.findTopByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public DemandReading getLatest(Long zoneId) {
        return repo.findTopByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public List<DemandReading> getRecent(Long zoneId, int count) {
        return repo.findRecentReadings(zoneId, count);
    }

    @Override
    public Double getTotalLatestDemand() {
        return repo.getTotalLatestDemand();
    }
}
