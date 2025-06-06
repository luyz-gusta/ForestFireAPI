package com.fiap.gs_forest_fire;

import com.fiap.gs_forest_fire.controllers.DroneController;
import com.fiap.gs_forest_fire.domain.dto.drone.RequestDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.drone.UpdateDroneDTO;
import com.fiap.gs_forest_fire.domain.entities.Drone;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.DroneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DroneControllerTest {
    private DroneService droneService;
    private DroneController droneController;

    @BeforeEach
    void setUp() {
        droneService = mock(DroneService.class);
        droneController = new DroneController(droneService);
    }

    @Test
    void testGetAllDrones() {
        List<Drone> mockList = Arrays.asList(new Drone(), new Drone());
        when(droneService.listAllDrones()).thenReturn(mockList);

        ResponseEntity<ApiListResponse<Drone>> response = droneController.getAllDrones();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getData().size());
    }

    @Test
    void testGetAllDronesByActive() {
        List<Drone> mockList = Arrays.asList(new Drone(), new Drone());
        when(droneService.listDronesActive()).thenReturn(mockList);

        ResponseEntity<ApiListResponse<Drone>> response = droneController.getAllDronesByActive();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getData().size());
    }

    @Test
    void testGetDroneById_Found() {
        Drone drone = new Drone();
        when(droneService.listDroneById(1L)).thenReturn(drone);

        ResponseEntity<ApiSingleResponse<Drone>> response = droneController.getDroneById(1L);
        ApiSingleResponse<Drone> expected =
                new ApiSingleResponse<>(200, "Requisição bem sucedida!", drone);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testGetDroneById_NotFound() {
        when(droneService.listDroneById(100L)).thenReturn(null);

        ResponseEntity<ApiSingleResponse<Drone>> response = droneController.getDroneById(100L);
        ApiSingleResponse<Drone> expected =
                new ApiSingleResponse<>(200, "Requisição bem sucedida!", null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testCreateDrone() {
        RequestDroneDTO dto = new RequestDroneDTO();
        Drone drone = new Drone();
        when(droneService.saveDrone(dto)).thenReturn(drone);

        ResponseEntity<ApiSingleResponse<Drone>> response = droneController.createDrone(dto);
        ApiSingleResponse<Drone> expected =
                new ApiSingleResponse<>(201, "Item criado com sucesso!", drone);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testUpdateDrone() {
        UpdateDroneDTO dto = new UpdateDroneDTO();
        Drone drone = new Drone();
        when(droneService.editDrone(dto)).thenReturn(drone);

        ResponseEntity<ApiSingleResponse<Drone>> response = droneController.updateDrone(dto);
        ApiSingleResponse<Drone> expected =
                new ApiSingleResponse<>(200, "Item atualizado com sucesso!", drone);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testToggleStatus() {
        Drone drone = new Drone();
        when(droneService.editDroneStatus(1L, "ACTIVE")).thenReturn(drone);

        ResponseEntity<ApiSingleResponse<Drone>> response = droneController.toogleStatus(1L, "ACTIVE");
        ApiSingleResponse<Drone> expected =
                new ApiSingleResponse<>(200, "Item atualizado com sucesso!", drone);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testDeleteDrone() {
        doNothing().when(droneService).excludeDrone(1L);

        ResponseEntity<ApiMessageResponse> response = droneController.deleteDrone(1L);
        ApiMessageResponse deleted = new ApiMessageResponse(200, "Item deletado com sucesso!");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(deleted, response.getBody());
    }
}
