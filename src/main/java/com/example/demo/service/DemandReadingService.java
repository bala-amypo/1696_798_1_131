package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingService {
    List<DemandReading> getRecentReadingsByZone(Long zoneId, int count);
}
