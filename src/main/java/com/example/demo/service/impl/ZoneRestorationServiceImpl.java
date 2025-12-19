package com.example.demo.service.impl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRecordRepository zoneRestorationRecordRepository;
    private final LoadSheddingEventRepository loadSheddingEventRepository;
    private final ZoneRepository zoneRepository;

    // EXACT constructor order
    public ZoneRestorationServiceImpl(
            ZoneRestorationRecordRepository zoneRestorationRecordRepository,
            LoadSheddingEventRepository loadSheddingEventRepository,
            ZoneRepository zoneRepository
    ) {
        this.zoneRestorationRecordRepository = zoneRestorationRecordRepository;
        this.loadSheddingEventRepository = loadSheddingEventRepository;
        this.zoneRepository = zoneRepository;
    }

    @Override
    public ZoneRestorationRecord restoreZone(ZoneRestorationRecord record) {
        return zoneRestorationRecordRepository.save(record);
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return zoneRestorationRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return zoneRestorationRecordRepository.findByZoneIdOrderByRestoredAtDesc(zoneId);
    }
}
