package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LoadSheddingEvent;

import java.util.List;

public interface LoadSheddingEventRepository extends JpaRepository<LoadSheddingEvent, Long> {
    List<LoadSheddingEvent> findByActiveTrueOrderByPriorityLevelAsc();
}
