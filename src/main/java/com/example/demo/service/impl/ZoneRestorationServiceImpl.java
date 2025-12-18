package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRepository;
import com.example.demo.service.ZoneRestorationService;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    @Autowired
    private ZoneRestorationRepository repo;

    @Override
    public ZoneRestorationRecord restoreZone(ZoneRestorationRecord record) {
        return repo.save(record);
    }

    @Override
    public Optional<ZoneRestorationRecord> getRecordById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return repo.findByZoneId(zoneId);
    }
}
