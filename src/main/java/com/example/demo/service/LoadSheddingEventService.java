package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.LoadSheddingEvent;

public interface LoadSheddingEventService {

    LoadSheddingEvent trigger(Long forecastId);

    Optional<LoadSheddingEvent> getById(Long id);

    List<LoadSheddingEvent> getByZone(Long zoneId);

    List<LoadSheddingEvent> getAll();
}
