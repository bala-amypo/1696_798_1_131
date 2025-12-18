package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.service.LoadSheddingEventService;

@Service
public class LoadSheddingEventServiceImpl implements LoadSheddingEventService {

    @Autowired
    private LoadSheddingEventRepository repository;

    @Override
    public LoadSheddingEvent trigger(Long forecastId) {
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setForecastId(forecastId);
        event.setActive(true);
        return repository.save(event);
    }

    @Override
    public Optional<LoadSheddingEvent> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<LoadSheddingEvent> getByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAll() {
        return repository.findAll();
    }
}
