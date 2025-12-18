package com.example.demo.repository;

import com.example.demo.entity.DemandReading;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {

    @Query("SELECT d FROM DemandReading d WHERE d.zone.id = :zoneId ORDER BY d.createdAt DESC")
    List<DemandReading> findRecentByZone(@Param("zoneId") Long zoneId, Pageable pageable);
}
