package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.drone.RequestDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.drone.UpdateDroneDTO;
import com.fiap.gs_forest_fire.domain.entities.Drone;
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


@Tag(name = "Drone", description = "Drone operations")
public interface DroneControllerSpecs {

    @Operation(summary = "Find all drones")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Drone>> getAllDrones();

    @Operation(summary = "Find drone by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Drone>> getDroneById(@PathVariable Long id);

    @Operation(summary = "Find drones by status when active status")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Drone>> getAllDronesByActive();


    @Operation(summary = "Create drone")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<Drone>> createDrone(@RequestBody RequestDroneDTO droneDTO);

    @Operation(summary = "Updade drone")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Drone>> updateDrone(@RequestBody @Valid UpdateDroneDTO droneDTO);

    @Operation(summary = "Toogle status drone")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Drone>> toogleStatus(@PathVariable Long id, @PathVariable String status);

    @Operation(summary = "Delete drone")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteDrone(@PathVariable Long id);


}
