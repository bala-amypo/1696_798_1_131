package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
package com.example.demo.repository;

import com.example.demo.entity.Zone;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {

    Optional<Zone> findByZoneName(String zoneName);

    List<Zone> findByActiveTrueOrderByPriorityLevelAsc();
}
