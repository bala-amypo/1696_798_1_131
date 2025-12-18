package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    @Autowired
    private SupplyForecastRepository repo;

    @Override
    public SupplyForecast createForecast(SupplyForecast forecast) {
        return repo.save(forecast);
    }

    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast forecast) {
        forecast.setId(id);
        return repo.save(forecast);
    }

    @Override
    public Optional<SupplyForecast> getForecastById(Long id) {
        return repo.findById(id);
    }

    @Override
    public SupplyForecast getLatestForecast() {
        return repo.findTopByOrderByGeneratedAtDesc();
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return repo.findAll();
    }
}
