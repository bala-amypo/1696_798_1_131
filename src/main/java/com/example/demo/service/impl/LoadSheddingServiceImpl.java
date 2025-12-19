package com.example.demo.service.impl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoadSheddingRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingRepository repository;

    public LoadSheddingServiceImpl(LoadSheddingRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoadSheddingEvent create(Long zoneId, LoadSheddingEvent event) {
        event.setZoneId(zoneId);
        return repository.save(event);
    }

    @Override
    public LoadSheddingEvent getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LoadShedding event not found"));
    }

    @Override
    public List<LoadSheddingEvent> getByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }
}
