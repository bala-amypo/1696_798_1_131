package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoadSheddingEvent;

public interface LoadSheddingEventService {

    LoadSheddingEvent create(LoadSheddingEvent event);

    List<LoadSheddingEvent> getByZone(Long zoneId);
}
