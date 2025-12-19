package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository demandReadingRepository;
    private final ZoneRepository zoneRepository;

    // EXACT constructor order
    public DemandReadingServiceImpl(DemandReadingRepository demandReadingRepository,
                                    ZoneRepository zoneRepository) {
        this.demandReadingRepository = demandReadingRepository;
        this.zoneRepository = zoneRepository;
    }

    @Override
    public DemandReading createReading(DemandReading reading) {
        return demandReadingRepository.save(reading);
    }

    @Override
    public List<DemandReading> getReadingsForZone(Long zoneId) {
        return demandReadingRepository.findByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public DemandReading getLatestReading(Long zoneId) {
        return demandReadingRepository.findFirstByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
        return getReadingsForZone(zoneId).stream().limit(limit).toList();
    }
}
