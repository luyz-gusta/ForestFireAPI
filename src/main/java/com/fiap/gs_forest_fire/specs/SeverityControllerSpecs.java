package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.severity.RequestSeverityDTO;
import com.fiap.gs_forest_fire.domain.dto.severity.UpdateSeverityDTO;
import com.fiap.gs_forest_fire.domain.entities.Severity;
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


@Tag(name = "Severity", description = "Severity operations")
public interface SeverityControllerSpecs {

    @Operation(summary = "Find all severitys")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Severity>> getAllSeveritys();

    @Operation(summary = "Find severity by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Severity>> getSeverityById(@PathVariable Long id);

    @Operation(summary = "Find severitys by status when active status")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Severity>> getAllSeveritysByActive();


    @Operation(summary = "Create severity")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<Severity>> createSeverity(@RequestBody RequestSeverityDTO severityDTO);

    @Operation(summary = "Updade severity")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Severity>> updateSeverity(@RequestBody @Valid UpdateSeverityDTO severityDTO);

    @Operation(summary = "Toogle status severity")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Severity>> toogleStatus(@PathVariable Long id);

    @Operation(summary = "Delete severity")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteSeverity(@PathVariable Long id);


}
