package com.example.demo.service.impl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository supplyForecastRepository;

    // EXACT constructor order
    public SupplyForecastServiceImpl(SupplyForecastRepository supplyForecastRepository) {
        this.supplyForecastRepository = supplyForecastRepository;
    }

    @Override
    public SupplyForecast createForecast(SupplyForecast forecast) {
        return supplyForecastRepository.save(forecast);
    }

    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast forecast) {
        SupplyForecast existing = getForecastById(id);
        existing.setAvailableSupplyMW(forecast.getAvailableSupplyMW());
        existing.setForecastStart(forecast.getForecastStart());
        existing.setForecastEnd(forecast.getForecastEnd());
        return supplyForecastRepository.save(existing);
    }

    @Override
    public SupplyForecast getForecastById(Long id) {
        return supplyForecastRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));
    }

    @Override
    public SupplyForecast getLatestForecast() {
        return supplyForecastRepository.findFirstByOrderByGeneratedAtDesc();
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return supplyForecastRepository.findAll();
    }
}
