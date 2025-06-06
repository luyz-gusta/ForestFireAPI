package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.operation.RequestOperationDTO;
import com.fiap.gs_forest_fire.domain.dto.operation.UpdateOperationDTO;
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


@Tag(name = "Operation", description = "Operation operations")
public interface OperationControllerSpecs {

    @Operation(summary = "Find all operations")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<com.fiap.gs_forest_fire.domain.entities.Operation>> getAllOperations();

    @Operation(summary = "Find operation by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<com.fiap.gs_forest_fire.domain.entities.Operation>> getOperationById(@PathVariable Long id);


    @Operation(summary = "Create operation")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<com.fiap.gs_forest_fire.domain.entities.Operation>> createOperation(@RequestBody RequestOperationDTO operationDTO);

    @Operation(summary = "Updade operation")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<com.fiap.gs_forest_fire.domain.entities.Operation>> updateOperation(@RequestBody @Valid UpdateOperationDTO operationDTO);

    @Operation(summary = "Delete operation")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteOperation(@PathVariable Long id);
}
