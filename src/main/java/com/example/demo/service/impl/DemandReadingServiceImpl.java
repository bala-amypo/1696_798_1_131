package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    @Autowired
    private DemandReadingRepository repository;

    @Override
    public List<DemandReading> getRecentReadingsByZone(Long zoneId, int count) {
        return repository.findRecentByZone(zoneId, PageRequest.of(0, count));
    }
}
