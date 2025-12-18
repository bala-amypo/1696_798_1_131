package com.example.demo.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.LoadSheddingEventService;

@Service
public class LoadSheddingEventServiceImpl implements LoadSheddingEventService {

    @Autowired
    private SupplyForecastRepository forecastRepo;

    @Autowired
    private DemandReadingRepository demandRepo;

    @Autowired
    private ZoneRepository zoneRepo;

    @Autowired
    private LoadSheddingEventRepository eventRepo;

    @Override
    public LoadSheddingEvent triggerLoadSheddingEvent(Long forecastId) {

        SupplyForecast forecast = forecastRepo.findById(forecastId).orElseThrow();

        double totalDemand = demandRepo.getTotalLatestDemand();
        double supply = forecast.getAvailableSupplyMW();

        if (totalDemand <= supply) return null;

        Zone zone = zoneRepo.findByActiveTrueOrderByPriorityLevelAsc().get(0);

        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setZone(zone);
        event.setEventStart(Instant.now());
        event.setReason("Demand exceeded supply");
        event.setTriggeredByForecastId(forecastId);
        event.setExpectedDemandReductionMW(totalDemand - supply);

        return eventRepo.save(event);
    }

    @Override
    public Optional<LoadSheddingEvent> getEventById(Long id) {
        return eventRepo.findById(id);
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return eventRepo.findByZoneId(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return eventRepo.findAll();
    }
}
