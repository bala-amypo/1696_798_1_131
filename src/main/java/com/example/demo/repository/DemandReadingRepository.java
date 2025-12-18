package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.DemandReading;

public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {

    // All readings for a zone
    List<DemandReading> findByZoneId(Long zoneId);

    // Latest reading for a zone
    DemandReading findTopByZoneIdOrderByTimestampDesc(Long zoneId);

    // Recent readings with limit
    @Query(value = "SELECT * FROM demand_reading WHERE zone_id = :zoneId ORDER BY timestamp DESC LIMIT :limit", nativeQuery = true)
    List<DemandReading> findRecentByZone(@Param("zoneId") Long zoneId, @Param("limit") int limit);
}
