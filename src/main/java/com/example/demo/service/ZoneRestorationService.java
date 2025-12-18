package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.ZoneRestorationRecord;

public interface ZoneRestorationService {

    ZoneRestorationRecord restoreZone(ZoneRestorationRecord record);

    Optional<ZoneRestorationRecord> getRecordById(Long id);

    List<ZoneRestorationRecord> getRecordsForZone(Long zoneId);
}
