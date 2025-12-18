package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LoadShedding;

import java.util.List;

public interface LoadSheddingRepository extends JpaRepository<LoadShedding, Long> {
    List<LoadShedding> findByActiveTrueOrderByPriorityLevelAsc();
}
