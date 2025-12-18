package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    @Autowired
    private SupplyForecastRepository repository;

    @Override
    public SupplyForecast save(SupplyForecast forecast) {
        return repository.save(forecast);
    }

    @Override
    public SupplyForecast update(Long id, SupplyForecast forecast) {
        forecast.setId(id);
        return repository.save(forecast);
    }

    @Override
    public Optional<SupplyForecast> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SupplyForecast getLatest() {
        // Make sure your repository has this method
        return repository.findTopByOrderByForecastTimeDesc();
    }

    @Override
    public List<SupplyForecast> getAll() {
        return repository.findAll();
    }
}
