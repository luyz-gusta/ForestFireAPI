package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.operation.RequestOperationDTO;
import com.fiap.gs_forest_fire.domain.dto.operation.UpdateOperationDTO;
import com.fiap.gs_forest_fire.domain.entities.Operation;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.OperationService;
import com.fiap.gs_forest_fire.specs.OperationControllerSpecs;
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
@RequestMapping("/operation")
public class OperationController implements OperationControllerSpecs {
    private OperationService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Operation>> getAllOperations() {
        try {
            List<Operation> operations = service.listAllOperations();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(operations));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Operation>> getOperationById(@PathVariable Long id) {
        try {
            Operation drone = service.listOperationById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(drone));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Operation>> createOperation(
            @RequestBody @Valid RequestOperationDTO operationDTO
    ) {
        try {
            Operation drone = service.saveOperation(operationDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(drone));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<Operation>> updateOperation(@RequestBody @Valid UpdateOperationDTO operationDTO) {
        try {
            Operation drone = service.editOperation(operationDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(drone));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteOperation(@PathVariable Long id) {
        try {
            service.excludeOperation(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
