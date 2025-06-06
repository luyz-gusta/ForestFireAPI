package com.fiap.gs_forest_fire.repositories;

import com.fiap.gs_forest_fire.domain.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
