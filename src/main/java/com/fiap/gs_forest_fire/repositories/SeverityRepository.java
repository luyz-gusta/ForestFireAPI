package com.fiap.gs_forest_fire.repositories;

import com.fiap.gs_forest_fire.domain.entities.Operation;
import com.fiap.gs_forest_fire.domain.entities.Severity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeverityRepository extends JpaRepository<Severity, Long> {
    List<Severity> findAllByStatusTrue();
}
