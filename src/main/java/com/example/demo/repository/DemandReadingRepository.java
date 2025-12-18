package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DemandReading;

public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {

    List<DemandReading> findByZoneId(Long zoneId);

    DemandReading findTopByZoneIdOrderByRecordedAtDesc();
}
