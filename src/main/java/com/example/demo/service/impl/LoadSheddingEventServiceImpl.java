package com.example.demo.service.impl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.*;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class LoadSheddingEventServiceImpl implements LoadSheddingService {

    // EXACT constructor order (VERY IMPORTANT)
    public LoadSheddingEventServiceImpl(
            SupplyForecastRepository supplyForecastRepository,
            ZoneRepository zoneRepository,
            DemandReadingRepository demandReadingRepository,
            LoadSheddingEventRepository loadSheddingEventRepository
    ) {
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {
        return LoadSheddingEvent.builder()
                .eventStart(new Timestamp(System.currentTimeMillis()))
                .reason("Auto load shedding")
                .expectedDemandReductionMW(0.0)
                .build();
    }

    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return null;
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return List.of();
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return List.of();
    }
}
