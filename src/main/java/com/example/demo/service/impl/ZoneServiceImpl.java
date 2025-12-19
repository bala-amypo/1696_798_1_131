package com.example.demo.service.impl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ZoneRestorationRepository;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRepository repository;

    public ZoneServiceImpl(ZoneRestorationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ZoneRestorationRecord create(ZoneRestorationRecord record) {
        return repository.save(record);
    }

    @Override
    public ZoneRestorationRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone restoration record not found"));
    }

    @Override
    public List<ZoneRestorationRecord> getByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }
}
