package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
