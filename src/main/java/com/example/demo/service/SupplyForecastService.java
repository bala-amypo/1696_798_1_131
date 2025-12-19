package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import java.util.List;

public interface SupplyForecastService {

    SupplyForecast create(SupplyForecast forecast);

    SupplyForecast update(Long id, SupplyForecast forecast);

    SupplyForecast getById(Long id);

    List<SupplyForecast> getAll();
}
