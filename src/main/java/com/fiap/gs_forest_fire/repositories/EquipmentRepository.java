package com.fiap.gs_forest_fire.repositories;

import com.fiap.gs_forest_fire.domain.entities.Drone;
import com.fiap.gs_forest_fire.domain.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
