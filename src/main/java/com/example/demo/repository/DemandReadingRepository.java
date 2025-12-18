package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.DemandReading;
public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {

    // Latest reading for a zone
    DemandReading findTopByZoneIdOrderByTimestampDesc(Long zoneId);

    // All readings for a zone
    List<DemandReading> findByZoneId(Long zoneId);
}