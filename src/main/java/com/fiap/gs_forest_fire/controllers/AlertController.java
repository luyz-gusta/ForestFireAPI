package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.alert.RequestAlertDTO;
import com.fiap.gs_forest_fire.domain.dto.alert.UpdateAlertDTO;
import com.fiap.gs_forest_fire.domain.entities.Alert;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.AlertService;
import com.fiap.gs_forest_fire.specs.AlertControllerSpecs;
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
@RequestMapping("/alert")
public class AlertController implements AlertControllerSpecs {
    private AlertService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Alert>> getAllAlerts() {
        try {
            List<Alert> alerts = service.listAllAlerts();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(alerts));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Alert>> getAlertById(@PathVariable Long id) {
        try {
            Alert alert = service.listAlertById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(alert));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Alert>> createAlert(
            @RequestBody @Valid RequestAlertDTO alertDTO
    ) {
        try {
            Alert alert = service.saveAlert(alertDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(alert));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<Alert>> updateAlert(@RequestBody @Valid UpdateAlertDTO alertDTO) {
        try {
            Alert alert = service.editAlert(alertDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(alert));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteAlert(@PathVariable Long id) {
        try {
            service.excludeAlert(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
