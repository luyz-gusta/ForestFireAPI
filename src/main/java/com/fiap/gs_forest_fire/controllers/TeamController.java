package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.team.RequestTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.ResponseTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.UpdateTeamDTO;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.TeamService;
import com.fiap.gs_forest_fire.specs.TeamControllerSpecs;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/team")
public class TeamController implements TeamControllerSpecs {
    private final TeamService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<ResponseTeamDTO>> getAllTeams() {
        try {
            List<ResponseTeamDTO> teams = service.listAllTeams();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(teams));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/active")
    public ResponseEntity<ApiListResponse<ResponseTeamDTO>> getAllTeamsByActive() {
        try {
            List<ResponseTeamDTO> teams = service.listTeamsActive();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(teams));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> getTeamById(@PathVariable Long id) {
        try {
            ResponseTeamDTO team = service.listTeamById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(team));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> createTeam(
            @RequestBody @Valid RequestTeamDTO teamDTO
    ) {
        try {
            ResponseTeamDTO team = service.saveTeam(teamDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(team));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> updateTeam(@RequestBody @Valid UpdateTeamDTO teamDTO) {
        try {
            ResponseTeamDTO team = service.editTeam(teamDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(team));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping("/toogle-status/{id}/status/{status}")
    @Transactional
    public ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> toogleStatus(@PathVariable Long id, @PathVariable String status) {
        try {
            ResponseTeamDTO team = service.editTeamStatus(id, status);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(team));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteTeam(@PathVariable Long id) {
        try {
            service.excludeTeam(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}