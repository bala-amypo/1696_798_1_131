package com.example.demo.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.Zone;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.LoadSheddingEventService;

@Service
public class LoadSheddingEventServiceImpl implements LoadSheddingEventService {

    @Autowired
    private LoadSheddingEventRepository eventRepo;

    @Autowired
    private ZoneRepository zoneRepo;

    @Override
    public LoadSheddingEvent trigger(Long forecastId) {
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setTriggeredByForecastId(forecastId);
        event.setEventStart(Instant.now());
        event.setActive(true); // make sure entity has active field if needed
        return eventRepo.save(event);
    }

    @Override
    public Optional<LoadSheddingEvent> getById(Long id) {
        return eventRepo.findById(id);
    }

    @Override
    public List<LoadSheddingEvent> getByZone(Long zoneId) {
        return eventRepo.findByZoneId(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAll() {
        return eventRepo.findAll();
    }
}
