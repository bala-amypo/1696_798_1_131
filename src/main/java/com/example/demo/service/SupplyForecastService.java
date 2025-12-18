package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.SupplyForecast;

public interface SupplyForecastService {

    SupplyForecast save(SupplyForecast forecast);

    Optional<SupplyForecast> getById(Long id);

    SupplyForecast getLatest();

    List<SupplyForecast> getAll();
}
