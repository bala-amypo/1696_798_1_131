package com.example.demo.service.impl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository repository;

    public SupplyForecastServiceImpl(SupplyForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplyForecast create(SupplyForecast forecast) {
        return repository.save(forecast);
    }

    @Override
    public SupplyForecast update(Long id, SupplyForecast forecast) {
        SupplyForecast existing = getById(id);
        forecast.setId(existing.getId());
        return repository.save(forecast);
    }

    @Override
    public SupplyForecast getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SupplyForecast not found"));
    }

    @Override
    public List<SupplyForecast> getAll() {
        return repository.findAll();
    }
}
