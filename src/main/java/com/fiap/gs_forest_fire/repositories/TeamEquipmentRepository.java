package com.fiap.gs_forest_fire.repositories;

import com.fiap.gs_forest_fire.domain.entities.Severity;
import com.fiap.gs_forest_fire.domain.entities.TeamEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamEquipmentRepository extends JpaRepository<TeamEquipment, Long> {

    @Query("select te from TeamEquipment te join te.equipment eq join te.team team where team.idTeam = :idTeam")
    List<TeamEquipment> findByIdTeam(@Param("idTeam") long idTeam);
}
