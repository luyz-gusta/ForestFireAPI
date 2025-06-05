package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.teamEquipment.RequestTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.teamEquipment.UpdateTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.entities.TeamEquipment;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.specs.error.ApiResponseBadRequest;
import com.fiap.gs_forest_fire.specs.error.ApiResponseDuplicatedResource;
import com.fiap.gs_forest_fire.specs.error.ApiResponseNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Tag(name = "TeamEquipment", description = "TeamEquipment operations")
public interface TeamEquipmentControllerSpecs {

    @Operation(summary = "Find all teamEquipment")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<TeamEquipment>> getAllTeamEquipments();

    @Operation(summary = "Find teamEquipment by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TeamEquipment>> getTeamEquipmentById(@PathVariable Long id);

    @Operation(summary = "Create teamEquipment")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<TeamEquipment>> createTeamEquipment(@RequestBody RequestTeamEquipmentDTO teamEquipmentDTO);

    @Operation(summary = "Updade teamEquipment")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TeamEquipment>> updateTeamEquipment(@RequestBody @Valid UpdateTeamEquipmentDTO teamEquipmentDTO);

    @Operation(summary = "Delete teamEquipment")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteTeamEquipment(@PathVariable Long id);
}
