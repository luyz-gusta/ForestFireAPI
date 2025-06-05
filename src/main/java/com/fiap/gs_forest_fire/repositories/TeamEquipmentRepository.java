package com.fiap.gs_forest_fire.repositories;

import com.fiap.gs_forest_fire.domain.entities.Severity;
import com.fiap.gs_forest_fire.domain.entities.TeamEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamEquipmentRepository extends JpaRepository<TeamEquipment, Long> {
    List<TeamEquipment> findByIdTeam(long idTeam);
}
