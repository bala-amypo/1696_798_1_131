package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneService;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository repo;

    @Override
    public Zone createZone(Zone zone) {
        return repo.save(zone);
    }

    @Override
    public Zone updateZone(Long id, Zone zone) {
        zone.setId(id);
        return repo.save(zone);
    }

    @Override
    public Optional<Zone> getZoneById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Zone> getAllZones() {
        return repo.findAll();
    }

    @Override
    public String deactivateZone(Long id) {
        Optional<Zone> optionalZone = repo.findById(id);
        if(optionalZone.isPresent()){
            Zone zone = optionalZone.get();
            zone.setActive(false);
            repo.save(zone);
            return "Zone deactivated successfully";
        }
        return "Zone not found";
    }
}
