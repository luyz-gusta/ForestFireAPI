package com.fiap.gs_forest_fire;

import com.fiap.gs_forest_fire.controllers.SeverityController;
import com.fiap.gs_forest_fire.domain.dto.severity.RequestSeverityDTO;
import com.fiap.gs_forest_fire.domain.dto.severity.UpdateSeverityDTO;
import com.fiap.gs_forest_fire.domain.entities.Severity;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.SeverityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SeverityControllerTest {

    private SeverityService severityService;
    private SeverityController severityController;

    @BeforeEach
    void setUp() {
        severityService = mock(SeverityService.class);
        severityController = new SeverityController(severityService);
    }

    @Test
    void testGetAllSeveritys() {
        List<Severity> severityList = Arrays.asList(new Severity(), new Severity());
        when(severityService.listAllSeveritys()).thenReturn(severityList);

        ResponseEntity<ApiListResponse<Severity>> response = severityController.getAllSeveritys();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getData().size());
    }

    @Test
    void testGetAllSeveritysByActive() {
        List<Severity> severityList = Arrays.asList(new Severity(), new Severity());
        when(severityService.listSeveritysActive()).thenReturn(severityList);

        ResponseEntity<ApiListResponse<Severity>> response = severityController.getAllSeveritysByActive();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getData().size());
    }

    @Test
    void testGetSeverityById_Found() {
        Severity severity = new Severity();
        when(severityService.listSeverityById(1L)).thenReturn(severity);

        ResponseEntity<ApiSingleResponse<Severity>> response = severityController.getSeverityById(1L);
        ApiSingleResponse<Severity> expected = new ApiSingleResponse<>(200, "Requisição bem sucedida!", severity);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testGetSeverityById_NotFound() {
        when(severityService.listSeverityById(100L)).thenReturn(null);

        ResponseEntity<ApiSingleResponse<Severity>> response = severityController.getSeverityById(100L);
        ApiSingleResponse<Severity> expected = new ApiSingleResponse<>(200, "Requisição bem sucedida!", null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testCreateSeverity() {
        RequestSeverityDTO dto = new RequestSeverityDTO();
        Severity severity = new Severity();
        when(severityService.saveSeverity(dto)).thenReturn(severity);

        ResponseEntity<ApiSingleResponse<Severity>> response = severityController.createSeverity(dto);
        ApiSingleResponse<Severity> expected = new ApiSingleResponse<>(201, "Item criado com sucesso!", severity);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testUpdateSeverity() {
        UpdateSeverityDTO dto = new UpdateSeverityDTO();
        Severity severity = new Severity();
        when(severityService.editSeverity(dto)).thenReturn(severity);

        ResponseEntity<ApiSingleResponse<Severity>> response = severityController.updateSeverity(dto);
        ApiSingleResponse<Severity> expected = new ApiSingleResponse<>(200, "Item atualizado com sucesso!", severity);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testToogleStatus() {
        Severity severity = new Severity();
        when(severityService.editSeverityStatus(1L)).thenReturn(severity);

        ResponseEntity<ApiSingleResponse<Severity>> response = severityController.toogleStatus(1L);
        ApiSingleResponse<Severity> expected = new ApiSingleResponse<>(200, "Item atualizado com sucesso!", severity);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testDeleteSeverity() {
        doNothing().when(severityService).excludeSeverity(1L);

        ResponseEntity<ApiMessageResponse> response = severityController.deleteSeverity(1L);
        ApiMessageResponse deleted = new ApiMessageResponse(200, "Item deletado com sucesso!");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(deleted, response.getBody());
    }
}
