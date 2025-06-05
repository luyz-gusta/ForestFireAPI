package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.equipment.RequestEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.teamEquipment.RequestTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.teamEquipment.UpdateTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.entities.Equipment;
import com.fiap.gs_forest_fire.domain.entities.Team;
import com.fiap.gs_forest_fire.domain.entities.TeamEquipment;
import com.fiap.gs_forest_fire.repositories.EquipmentRepository;
import com.fiap.gs_forest_fire.repositories.TeamEquipmentRepository;
import com.fiap.gs_forest_fire.repositories.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamEquipmentService {
    private final TeamEquipmentRepository repository;
    private final TeamRepository teamRepository;
    private final EquipmentRepository equipmentRepository;

    public List<TeamEquipment> listAllTeamsEquipments() {
        return repository
                .findAll();
    }

    public TeamEquipment listTeamsEquipmentById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<TeamEquipment> listTeamsEquipmentByIdTeam(Long idTeam) {
        return repository.findByIdTeam(idTeam);
    }

    public TeamEquipment saveTeamEquipment(RequestTeamEquipmentDTO teamEquipmentDTO) {
        Team team = teamRepository.findById(teamEquipmentDTO.getIdTeam()).orElseThrow(EntityNotFoundException::new);
        Equipment equipment = equipmentRepository.findById(teamEquipmentDTO.getIdEquipment()).orElseThrow(EntityNotFoundException::new);

        TeamEquipment teamEquipment = new TeamEquipment(team, equipment);

        repository.save(teamEquipment);
        return teamEquipment;
    }

    @Transactional
    public TeamEquipment editTeamEquipment(UpdateTeamEquipmentDTO teamEquipmentDTO) {
        Team team = teamRepository.findById(teamEquipmentDTO.getIdTeam()).orElseThrow(EntityNotFoundException::new);
        Equipment equipment = equipmentRepository.findById(teamEquipmentDTO.getIdEquipment()).orElseThrow(EntityNotFoundException::new);
        TeamEquipment teamEquipment = repository.findById(teamEquipmentDTO.getIdTeamEquipment()).orElseThrow(EntityNotFoundException::new);

        teamEquipment.setUpdateTeamEquipment(team, equipment);
        return teamEquipment;
    }


    @Transactional
    public void excludeTeamEquipment(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
