package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DemandReading;

public interface DemandReadingService {
    DemandReading save(DemandReading reading);
    DemandReading getById(Long id);
    DemandReading getByZone(Long zoneId);
    DemandReading getLatest(Long zoneId);
    List<DemandReading> getRecent(Long zoneId, int count);
    Double getTotalLatestDemand();
}
