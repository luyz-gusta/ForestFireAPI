package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.drone.RequestDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.drone.UpdateDroneDTO;
import com.fiap.gs_forest_fire.domain.entities.Drone;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.DroneService;
import com.fiap.gs_forest_fire.specs.DroneControllerSpecs;
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
@RequestMapping("/drone")
public class DroneController implements DroneControllerSpecs {
    private DroneService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Drone>> getAllDrones() {
        try {
            List<Drone> drones = service.listAllDrones();

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(drones));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/active")
    public ResponseEntity<ApiListResponse<Drone>> getAllDronesByActive() {
        try {
            List<Drone> drones = service.listDronesActive();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(drones));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Drone>> getDroneById(@PathVariable Long id) {
        try {
            Drone drone = service.listDroneById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(drone));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Drone>> createDrone(
            @RequestBody @Valid RequestDroneDTO equipmentDTO
    ) {
        try {
            Drone drone = service.saveDrone(equipmentDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(drone));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<Drone>> updateDrone(@RequestBody @Valid UpdateDroneDTO equipmentDTO) {
        try {
            Drone drone = service.editDrone(equipmentDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(drone));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping("/toogle-status/{id}/status/{status}")
    @Transactional
    public ResponseEntity<ApiSingleResponse<Drone>> toogleStatus(@PathVariable Long id, @PathVariable String status) {
        try {
            Drone drone = service.editDroneStatus(id, status);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(drone));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteDrone(@PathVariable Long id) {
        try {
            service.excludeDrone(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
