package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.monitoring.RequestMonitoringDTO;
import com.fiap.gs_forest_fire.domain.dto.monitoring.UpdateMonitoringDTO;
import com.fiap.gs_forest_fire.domain.entities.Monitoring;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.MonitoringService;
import com.fiap.gs_forest_fire.specs.MonitoringControllerSpecs;
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
@RequestMapping("/monitoring")
public class MonitoringController implements MonitoringControllerSpecs {
    private MonitoringService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Monitoring>> getAllMonitorings() {
        try {
            List<Monitoring> monitorings = service.listAllMonitorings();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(monitorings));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Monitoring>> getMonitoringById(@PathVariable Long id) {
        try {
            Monitoring monitoring = service.listMonitoringById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(monitoring));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Monitoring>> createMonitoring(
            @RequestBody @Valid RequestMonitoringDTO monitoringDTO
    ) {
        try {
            Monitoring monitoring = service.saveMonitoring(monitoringDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(monitoring));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<Monitoring>> updateMonitoring(@RequestBody @Valid UpdateMonitoringDTO monitoringDTO) {
        try {
            Monitoring monitoring = service.editMonitoring(monitoringDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(monitoring));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteMonitoring(@PathVariable Long id) {
        try {
            service.excludeMonitoring(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
