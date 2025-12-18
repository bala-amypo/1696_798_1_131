package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DemandReading;

@Repository
public interface DemandReadingRepo extends JpaRepository<DemandReading, Long> {

    List<DemandReading> findByZoneId(Long zoneId);

    DemandReading findTopByZoneIdOrderByRecordedAtDesc(Long zoneId);

    @Query(
        value = """
            SELECT * FROM demand_reading
            WHERE zone_id = :zoneId
            ORDER BY recorded_at DESC
            LIMIT :limit
        """,
        nativeQuery = true
    )
    List<DemandReading> findRecentReadings(
            @Param("zoneId") Long zoneId,
            @Param("limit") int limit
    );

    @Query(
        value = """
            SELECT SUM(d.demand_mw)
            FROM demand_reading d
            WHERE d.recorded_at = (
                SELECT MAX(dr.recorded_at)
                FROM demand_reading dr
                WHERE dr.zone_id = d.zone_id
            )
        """,
        nativeQuery = true
    )
    Double getTotalLatestDemand();
}
