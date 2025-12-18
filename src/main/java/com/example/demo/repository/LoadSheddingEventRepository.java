package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoadSheddingEvent;

@Repository
public interface LoadSheddingEventRepo extends JpaRepository<LoadSheddingEvent, Long> {

    List<LoadSheddingEvent> findByZoneId(Long zoneId);
}
