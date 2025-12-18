package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository repo;

    @Override
    public Zone save(Zone zone) {
        return repo.save(zone);
    }

    @Override
    public Zone update(Long id, Zone zone) {
        zone.setId(id);
        return repo.save(zone);
    }

    @Override
    public Optional<Zone> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Zone> getAll() {
        return repo.findAll();
    }

    @Override
    public String deactivate(Long id) {
        Optional<Zone> zone = repo.findById(id);
        if (zone.isPresent()) {
            zone.get().setActive(false);
            repo.save(zone.get());
            return "Zone Deactivated";
        }
        return "Zone Not Found";
    }
}
