package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.equipment.RequestEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import com.fiap.gs_forest_fire.domain.entities.Equipment;
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


@Tag(name = "Equipment", description = "Equipment operations")
public interface EquipmentControllerSpecs {

    @Operation(summary = "Find all equipments")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Equipment>> getAllEquipments();

    @Operation(summary = "Find equipment by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Equipment>> getEquipmentById(@PathVariable Long id);

    @Operation(summary = "Find equipments by status when active status")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Equipment>> getAllEquipmentsByActive();


    @Operation(summary = "Create equipment")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<Equipment>> createEquipment(@RequestBody RequestEquipmentDTO equipmentDTO);

    @Operation(summary = "Updade equipment")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Equipment>> updateEquipment(@RequestBody @Valid UpdateEquipmentDTO equipmentDTO);

    @Operation(summary = "Toogle status equipment")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Equipment>> toogleStatus(@PathVariable Long id);

    @Operation(summary = "Delete equipment")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteEquipment(@PathVariable Long id);


}
