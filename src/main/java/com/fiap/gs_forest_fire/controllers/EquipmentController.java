package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.equipment.RequestEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import com.fiap.gs_forest_fire.domain.entities.Equipment;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.EquipmentService;
import com.fiap.gs_forest_fire.specs.EquipmentControllerSpecs;
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
@RequestMapping("/equipment")
public class EquipmentController implements EquipmentControllerSpecs {
    private EquipmentService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Equipment>> getAllEquipments() {
        try {
            List<Equipment> equipments = service.listAllEquipments();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(equipments));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/active")
    public ResponseEntity<ApiListResponse<Equipment>> getAllEquipmentsByActive() {
        try {
            List<Equipment> equipments = service.listEquipmentsActive();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(equipments));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Equipment>> getEquipmentById(@PathVariable Long id) {
        try {
            Equipment equipment = service.listEquipmentById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(equipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Equipment>> createEquipment(
            @RequestBody @Valid RequestEquipmentDTO equipmentDTO
    ) {
        try {
            Equipment equipment = service.saveEquipment(equipmentDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(equipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<Equipment>> updateEquipment(@RequestBody @Valid UpdateEquipmentDTO equipmentDTO) {
        try {
            Equipment equipment = service.editEquipment(equipmentDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(equipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping("/toogle-status/{id}")
    @Transactional
    public ResponseEntity<ApiSingleResponse<Equipment>> toogleStatus(@PathVariable Long id) {
        try {
            Equipment equipment = service.editEquipmentStatus(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(equipment));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteEquipment(@PathVariable Long id) {
        try {
            service.excludeEquipment(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
