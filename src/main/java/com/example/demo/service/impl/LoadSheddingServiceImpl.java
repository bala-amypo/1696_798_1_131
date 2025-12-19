package com.example.demo.service.impl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class LoadSheddingEventServiceImpl implements LoadSheddingService {

    private final SupplyForecastRepository supplyForecastRepository;
    private final ZoneRepository zoneRepository;
    private final DemandReadingRepository demandReadingRepository;
    private final LoadSheddingEventRepository loadSheddingEventRepository;

    // EXACT constructor order (DO NOT CHANGE)
    public LoadSheddingEventServiceImpl(
            SupplyForecastRepository supplyForecastRepository,
            ZoneRepository zoneRepository,
            DemandReadingRepository demandReadingRepository,
            LoadSheddingEventRepository loadSheddingEventRepository
    ) {
        this.supplyForecastRepository = supplyForecastRepository;
        this.zoneRepository = zoneRepository;
        this.demandReadingRepository = demandReadingRepository;
        this.loadSheddingEventRepository = loadSheddingEventRepository;
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {
        LoadSheddingEvent event = LoadSheddingEvent.builder()
                .eventStart(new Timestamp(System.currentTimeMillis()))
                .reason("Auto load shedding")
                .expectedDemandReductionMW(0.0)
                .build();
        return loadSheddingEventRepository.save(event);
    }

    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return loadSheddingEventRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return loadSheddingEventRepository.findByZoneIdOrderByEventStartDesc(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return loadSheddingEventRepository.findAll();
    }
}
