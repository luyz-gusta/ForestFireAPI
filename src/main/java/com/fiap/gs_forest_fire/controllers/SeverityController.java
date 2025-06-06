package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.severity.RequestSeverityDTO;
import com.fiap.gs_forest_fire.domain.dto.severity.UpdateSeverityDTO;
import com.fiap.gs_forest_fire.domain.entities.Severity;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.SeverityService;
import com.fiap.gs_forest_fire.specs.SeverityControllerSpecs;
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
@RequestMapping("/severity")
public class SeverityController implements SeverityControllerSpecs {
    private SeverityService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Severity>> getAllSeveritys() {
        try {
            List<Severity> severitys = service.listAllSeveritys();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(severitys));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/active")
    public ResponseEntity<ApiListResponse<Severity>> getAllSeveritysByActive() {
        try {
            List<Severity> severitys = service.listSeveritysActive();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(severitys));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Severity>> getSeverityById(@PathVariable Long id) {
        try {
            Severity severity = service.listSeverityById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(severity));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Severity>> createSeverity(
            @RequestBody @Valid RequestSeverityDTO severityDTO
    ) {
        try {
            Severity severity = service.saveSeverity(severityDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(severity));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<Severity>> updateSeverity(@RequestBody @Valid UpdateSeverityDTO severityDTO) {
        try {
            Severity severity = service.editSeverity(severityDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(severity));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping("/toogle-status/{id}")
    @Transactional
    public ResponseEntity<ApiSingleResponse<Severity>> toogleStatus(@PathVariable Long id) {
        try {
            Severity severity = service.editSeverityStatus(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(severity));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteSeverity(@PathVariable Long id) {
        try {
            service.excludeSeverity(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
