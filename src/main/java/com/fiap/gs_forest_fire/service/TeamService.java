package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.team.RequestTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.ResponseTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.UpdateTeamDTO;
import com.fiap.gs_forest_fire.domain.entities.Login;
import com.fiap.gs_forest_fire.domain.entities.Team;
import com.fiap.gs_forest_fire.infra.mapper.team.TeamMapper;
import com.fiap.gs_forest_fire.repositories.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository repository;
    private final TeamMapper mapper;
    private final LoginService loginService;


    public List<ResponseTeamDTO> listAllTeams() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toTeamResponse)
                .toList();
    }

    public List<ResponseTeamDTO> listTeamsActive() {
        return repository
                .findAllByStatusTrue()
                .stream()
                .map(mapper::toTeamResponse)
                .toList();
    }

    public ResponseTeamDTO listTeamById(Long id) {
        Team team = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toTeamResponse(team);
    }

    public ResponseTeamDTO saveTeam(RequestTeamDTO teamDTO) {
        loginService.validEmail(teamDTO.getEmail());

        Login login = new Login(teamDTO);
        Team team = new Team(teamDTO, login);

        repository.save(team);
        return mapper.toTeamResponse(team);
    }

    @Transactional
    public ResponseTeamDTO editTeam(UpdateTeamDTO teamDTO) {
        Team team = repository
                .findById(teamDTO.getIdTeam())
                .orElseThrow(EntityNotFoundException::new);

        team.setUpdatedTeam(teamDTO);
        return mapper.toTeamResponse(team);
    }

    @Transactional
    public ResponseTeamDTO editTeamStatus(Long id, String status) {
        Team team = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        team.setStatus(status);

        return mapper.toTeamResponse(team);
    }

    @Transactional
    public void excludeTeam(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
