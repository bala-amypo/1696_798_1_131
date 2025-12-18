package com.example.demo.service;

import com.example.demo.entity.Zone;
import java.util.List;
import java.util.Optional;

public interface ZoneService {

    Zone createZone(Zone zone);

    Zone updateZone(Long id, Zone zone);

    Optional<Zone> getZoneById(Long id);

    List<Zone> getAllZones();

    String deactivateZone(Long id);
}
