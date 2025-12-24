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

for (Zone zone : activeZones) {
    Optional<DemandReading> opt =
            readingRepo.findFirstByZoneIdOrderByRecordedAtDesc(zone.getId());

    if (opt.isPresent()) {
        totalDemand += opt.get().getDemandMW();
    }
}


    // ✅ REQUIRED BY TEST
    if (totalDemand <= forecast.getAvailableSupplyMW()) {
        throw new IllegalStateException("No overload detected");
    }

    Zone targetZone = activeZones.get(activeZones.size() - 1);

    double reduction = totalDemand - forecast.getAvailableSupplyMW();

    LoadSheddingEvent event = LoadSheddingEvent.builder()
            .zone(targetZone)
            .eventStart(Instant.now())
            .reason("Overload")
            .triggeredByForecastId(forecastId)
            .expectedDemandReductionMW(reduction)
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