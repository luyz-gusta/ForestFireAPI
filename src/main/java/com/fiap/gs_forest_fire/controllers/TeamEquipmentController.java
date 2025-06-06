package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.teamEquipment.RequestTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.teamEquipment.UpdateTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.entities.TeamEquipment;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.TeamEquipmentService;
import com.fiap.gs_forest_fire.specs.TeamEquipmentControllerSpecs;
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
@RequestMapping("/teamEquipment")
public class TeamEquipmentController implements TeamEquipmentControllerSpecs {
    private final TeamEquipmentService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<TeamEquipment>> getAllTeamEquipments() {
        try {
            List<TeamEquipment> teamEquipment = service.listAllTeamsEquipments();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(teamEquipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<TeamEquipment>> getTeamEquipmentById(@PathVariable Long id) {
        try {
            TeamEquipment teamEquipment = service.listTeamsEquipmentById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(teamEquipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<TeamEquipment>> createTeamEquipment(
            @RequestBody @Valid RequestTeamEquipmentDTO teamEquipmentDTO
    ) {
        try {
            TeamEquipment teamEquipment = service.saveTeamEquipment(teamEquipmentDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(teamEquipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<TeamEquipment>> updateTeamEquipment(@RequestBody @Valid UpdateTeamEquipmentDTO teamEquipmentDTO) {
        try {
            TeamEquipment teamEquipment = service.editTeamEquipment(teamEquipmentDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(teamEquipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteTeamEquipment(@PathVariable Long id) {
        try {
            service.excludeTeamEquipment(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}