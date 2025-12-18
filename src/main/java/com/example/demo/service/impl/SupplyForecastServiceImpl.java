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
    private SupplyForecastRepository repository;

    @Override
    public SupplyForecast save(SupplyForecast forecast) {
        return repository.save(forecast);
    }

    @Override
    public Optional<SupplyForecast> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SupplyForecast getLatest() {
        return repository
                .findTopByOrderByForecastTimeDesc()
                .orElse(null);
    }

    @Override
    public List<SupplyForecast> getAll() {
        return repository.findAll();
    }
}
