package com.example.demo.service;

import com.example.demo.entity.LoadSheddingEvent;
import java.util.List;

public interface LoadSheddingService {

    LoadSheddingEvent create(Long zoneId, LoadSheddingEvent event);

    LoadSheddingEvent getById(Long id);

    List<LoadSheddingEvent> getByZone(Long zoneId);
}
