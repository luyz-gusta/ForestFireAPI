package com.fiap.gs_forest_fire;

import com.fiap.gs_forest_fire.controllers.OperationController;
import com.fiap.gs_forest_fire.domain.dto.operation.RequestOperationDTO;
import com.fiap.gs_forest_fire.domain.dto.operation.UpdateOperationDTO;
import com.fiap.gs_forest_fire.domain.entities.Operation;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.OperationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OperationControllerTest {

    private OperationService operationService;
    private OperationController operationController;

    @BeforeEach
    void setUp() {
        operationService = mock(OperationService.class);
        operationController = new OperationController(operationService);
    }

    @Test
    void testGetAllOperations() {
        List<Operation> operations = Arrays.asList(new Operation(), new Operation());
        when(operationService.listAllOperations()).thenReturn(operations);

        ResponseEntity<ApiListResponse<Operation>> response = operationController.getAllOperations();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getData().size());
    }

    @Test
    void testGetOperationById_Found() {
        Operation operation = new Operation();
        when(operationService.listOperationById(1L)).thenReturn(operation);

        ResponseEntity<ApiSingleResponse<Operation>> response = operationController.getOperationById(1L);
        ApiSingleResponse<Operation> expected = new ApiSingleResponse<>(200, "Requisição bem sucedida!", operation);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testGetOperationById_NotFound() {
        when(operationService.listOperationById(999L)).thenReturn(null);

        ResponseEntity<ApiSingleResponse<Operation>> response = operationController.getOperationById(999L);
        ApiSingleResponse<Operation> expected = new ApiSingleResponse<>(200, "Requisição bem sucedida!", null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testCreateOperation() {
        RequestOperationDTO dto = new RequestOperationDTO();
        Operation operation = new Operation();
        when(operationService.saveOperation(dto)).thenReturn(operation);

        ResponseEntity<ApiSingleResponse<Operation>> response = operationController.createOperation(dto);
        ApiSingleResponse<Operation> expected = new ApiSingleResponse<>(201, "Item criado com sucesso!", operation);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testUpdateOperation() {
        UpdateOperationDTO dto = new UpdateOperationDTO();
        Operation operation = new Operation();
        when(operationService.editOperation(dto)).thenReturn(operation);

        ResponseEntity<ApiSingleResponse<Operation>> response = operationController.updateOperation(dto);
        ApiSingleResponse<Operation> expected = new ApiSingleResponse<>(200, "Item atualizado com sucesso!", operation);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testDeleteOperation() {
        doNothing().when(operationService).excludeOperation(1L);

        ResponseEntity<ApiMessageResponse> response = operationController.deleteOperation(1L);
        ApiMessageResponse expected = new ApiMessageResponse(200, "Item deletado com sucesso!");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }
}
