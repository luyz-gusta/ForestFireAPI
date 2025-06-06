package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.monitoring.RequestMonitoringDTO;
import com.fiap.gs_forest_fire.domain.dto.monitoring.UpdateMonitoringDTO;
import com.fiap.gs_forest_fire.domain.entities.Monitoring;
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


@Tag(name = "Monitoring", description = "Monitoring operations")
public interface MonitoringControllerSpecs {

    @Operation(summary = "Find all monitorings")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Monitoring>> getAllMonitorings();

    @Operation(summary = "Find monitoring by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Monitoring>> getMonitoringById(@PathVariable Long id);


    @Operation(summary = "Create monitoring")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<Monitoring>> createMonitoring(@RequestBody RequestMonitoringDTO monitoringDTO);

    @Operation(summary = "Updade monitoring")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Monitoring>> updateMonitoring(@RequestBody @Valid UpdateMonitoringDTO monitoringDTO);

    @Operation(summary = "Delete monitoring")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteMonitoring(@PathVariable Long id);
}
