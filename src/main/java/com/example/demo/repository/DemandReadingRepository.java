package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DemandReading;

@Repository
public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {

    List<DemandReading> findByZoneId(Long zoneId);

    DemandReading findTopByZoneIdOrderByRecordedAtDesc();
}
