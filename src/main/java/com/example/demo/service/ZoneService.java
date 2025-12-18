package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Zone;

public interface ZoneService {

    Zone save(Zone zone);
    Zone update(Long id, Zone zone);
    Optional<Zone> getById(Long id);
    List<Zone> getAll();
    String deactivate(Long id);
}
