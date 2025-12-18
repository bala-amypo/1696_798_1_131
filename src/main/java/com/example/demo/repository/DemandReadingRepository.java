package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DemandReading;

@Repository
public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {

    // Get the latest demand reading for a zone
    DemandReading findTopByZoneIdOrderByRecordedAtDesc(Long zoneId);

    // Get recent N readings for a zone
    @Query(value = "SELECT * FROM demand_reading WHERE zone_id = :zoneId ORDER BY recorded_at DESC LIMIT :limit", nativeQuery = true)
    List<DemandReading> findRecentReadings(Long zoneId, int limit);

    // Get total latest demand (example query, adjust according to your schema)
    @Query("SELECT SUM(d.value) FROM DemandReading d WHERE d.recordedAt = (SELECT MAX(dr.recordedAt) FROM DemandReading dr)")
    Double getTotalLatestDemand();
}
