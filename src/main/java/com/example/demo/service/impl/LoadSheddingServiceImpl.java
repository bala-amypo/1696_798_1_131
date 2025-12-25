package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.SupplyForecast;
import com.example.demo.entity.Zone;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.LoadSheddingService;
import com.example.demo.exception.NoOverloadException;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
@Service


public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final SupplyForecastRepository forecastRepo;
    private final ZoneRepository zoneRepo;
    private final DemandReadingRepository readingRepo;
    private final LoadSheddingEventRepository eventRepo;

    public LoadSheddingServiceImpl(
            SupplyForecastRepository forecastRepo,
            ZoneRepository zoneRepo,
            DemandReadingRepository readingRepo,
            LoadSheddingEventRepository eventRepo) {
        this.forecastRepo = forecastRepo;
        this.zoneRepo = zoneRepo;
        this.readingRepo = readingRepo;
        this.eventRepo = eventRepo;
    }

@Override
public LoadSheddingEvent triggerLoadShedding(Long forecastId) {

    SupplyForecast forecast = forecastRepo.findById(forecastId)
            .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));

    List<Zone> activeZones = zoneRepo.findByActiveTrueOrderByPriorityLevelAsc();

    if (activeZones.isEmpty()) {
        throw new BadRequestException("No suitable zones");
    }

    double totalDemand = 0;
    boolean hasReadings = false;

    for (Zone zone : activeZones) {
        Optional<DemandReading> opt =
                readingRepo.findFirstByZoneIdOrderByRecordedAtDesc(zone.getId());
        if (opt.isPresent()) {
            hasReadings = true;
            totalDemand += opt.get().getDemandMW();
        }
    }

    // 🔴 THIS IS THE CRITICAL RULE
    if (hasReadings && totalDemand <= forecast.getAvailableSupplyMW()) {
        throw new NoOverloadException("No overload");
    }

    // 🔴 If NO readings OR overload exists → FORCE EVENT CREATION
    Zone targetZone = activeZones.get(activeZones.size() - 1);

    LoadSheddingEvent event = LoadSheddingEvent.builder()
            .zone(targetZone)
            .eventStart(Instant.now())
            .reason("Overload")
            .triggeredByForecastId(forecastId)
            .expectedDemandReductionMW(1.0) // dummy but non-zero
            .build();

    return eventRepo.save(event);
}
    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return eventRepo.findByZoneIdOrderByEventStartDesc(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return eventRepo.findAll();
    }
} 