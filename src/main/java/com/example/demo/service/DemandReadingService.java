package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.DemandReading;

public interface DemandReadingService {

    DemandReading save(DemandReading reading);

    Optional<DemandReading> getById(Long id);

    List<DemandReading> getByZone(Long zoneId);

    DemandReading getLatest(Long zoneId);

    List<DemandReading> getRecent(Long zoneId, int limit);
}
