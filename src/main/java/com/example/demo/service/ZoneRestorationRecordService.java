package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.ZoneRestorationRecord;

public interface ZoneRestorationRecordService {

    ZoneRestorationRecord save(ZoneRestorationRecord record);

    Optional<ZoneRestorationRecord> getById(Long id);

    List<ZoneRestorationRecord> getByZone(Long zoneId);
}
