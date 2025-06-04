package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.team.RequestTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.ResponseTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.UpdateTeamDTO;
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


@Tag(name = "Team", description = "Team operations")
public interface TeamControllerSpecs {

    @Operation(summary = "Find all teams")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<ResponseTeamDTO>> getAllTeams();

    @Operation(summary = "Find team by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> getTeamById(@PathVariable Long id);

    @Operation(summary = "Find teams by status when active status")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<ResponseTeamDTO>> getAllTeamsByActive();


    @Operation(summary = "Create team")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> createTeam(@RequestBody RequestTeamDTO teamDTO);

    @Operation(summary = "Updade team")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> updateTeam(@RequestBody @Valid UpdateTeamDTO teamDTO);

    @Operation(summary = "Toogle status team")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseTeamDTO>> toogleStatus(@PathVariable Long id, @PathVariable String status);

    @Operation(summary = "Delete team")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteTeam(@PathVariable Long id);


}
