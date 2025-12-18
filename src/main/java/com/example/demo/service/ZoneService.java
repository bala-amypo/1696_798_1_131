package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Zone;

public interface ZoneService {

    Zone save(Zone zone);                // renamed to 'save' to match controller
    Zone update(Long id, Zone zone);     // renamed to 'update'
    Optional<Zone> getById(Long id);     // renamed
    List<Zone> getAll();                  // renamed
    String deactivate(Long id);           // renamed
}
