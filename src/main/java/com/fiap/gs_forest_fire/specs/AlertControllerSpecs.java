package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.alert.RequestAlertDTO;
import com.fiap.gs_forest_fire.domain.dto.alert.UpdateAlertDTO;
import com.fiap.gs_forest_fire.domain.entities.Alert;
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


@Tag(name = "Alert", description = "Alert operations")
public interface AlertControllerSpecs {

    @Operation(summary = "Find all alerts")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Alert>> getAllAlerts();

    @Operation(summary = "Find alert by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Alert>> getAlertById(@PathVariable Long id);


    @Operation(summary = "Create alert")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<Alert>> createAlert(@RequestBody RequestAlertDTO alertDTO);

    @Operation(summary = "Updade alert")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Alert>> updateAlert(@RequestBody @Valid UpdateAlertDTO alertDTO);

    @Operation(summary = "Delete alert")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteAlert(@PathVariable Long id);
}
