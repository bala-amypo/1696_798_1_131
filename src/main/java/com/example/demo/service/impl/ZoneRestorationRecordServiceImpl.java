package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import com.example.demo.service.ZoneRestorationRecordService;

@Service
public class ZoneRestorationRecordServiceImpl implements ZoneRestorationRecordService {

    @Autowired
    private ZoneRestorationRecordRepository repo;

    @Override
    public ZoneRestorationRecord save(ZoneRestorationRecord record) {
        return repo.save(record);
    }

    @Override
    public Optional<ZoneRestorationRecord> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ZoneRestorationRecord> getByZone(Long zoneId) {
        return repo.findByZoneId(zoneId);
    }
}
