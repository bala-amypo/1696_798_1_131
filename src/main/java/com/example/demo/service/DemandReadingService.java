package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingService {

    DemandReading create(DemandReading reading);

    DemandReading getById(Long id);

    List<DemandReading> getByZone(Long zoneId);
}
