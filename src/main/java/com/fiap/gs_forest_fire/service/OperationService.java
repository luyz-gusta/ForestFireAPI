package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.operation.RequestOperationDTO;
import com.fiap.gs_forest_fire.domain.dto.operation.UpdateOperationDTO;
import com.fiap.gs_forest_fire.domain.entities.Operation;
import com.fiap.gs_forest_fire.domain.entities.Severity;
import com.fiap.gs_forest_fire.repositories.OperationRepository;
import com.fiap.gs_forest_fire.repositories.SeverityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OperationService {
    private final OperationRepository repository;
    private final SeverityRepository severityRepository;

    public List<Operation> listAllOperations() {
        return repository
                .findAll();
    }

    public Operation listOperationById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Operation saveOperation(RequestOperationDTO operationDTO) {
        Severity severity = severityRepository.findById(operationDTO.getIdSeverity()).orElseThrow(EntityNotFoundException::new);
        Operation alert = new Operation(operationDTO, severity);

        repository.save(alert);
        return alert;
    }

    @Transactional
    public Operation editOperation(UpdateOperationDTO operationDTO) {
        Severity severity = severityRepository.findById(operationDTO.getIdSeverity()).orElseThrow(EntityNotFoundException::new);
        Operation alert = repository
                .findById(operationDTO.getIdOperation())
                .orElseThrow(EntityNotFoundException::new);

        alert.setUpdatedOperation(operationDTO, severity);
        return alert;
    }

    @Transactional
    public void excludeOperation(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
