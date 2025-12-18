package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.LoadSheddingEvent;

public interface LoadSheddingService {

    LoadSheddingEvent triggerLoadShedding(Long forecastId);

    Optional<LoadSheddingEvent> getEventById(Long id);

    List<LoadSheddingEvent> getEventsForZone(Long zoneId);

    List<LoadSheddingEvent> getAllEvents();
}
