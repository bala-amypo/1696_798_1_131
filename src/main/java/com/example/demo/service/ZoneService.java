package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Zone;

public interface ZoneService {

    Zone createZone(Zone zone);

    Zone updateZone(Long id, Zone zone);

    Optional<Zone> getZoneById(Long id);

    List<Zone> getAllZones();

    String deactivateZone(Long id);
}
