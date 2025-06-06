package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.severity.RequestSeverityDTO;
import com.fiap.gs_forest_fire.domain.dto.severity.UpdateSeverityDTO;
import com.fiap.gs_forest_fire.domain.entities.Severity;
import com.fiap.gs_forest_fire.repositories.SeverityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeverityService {
    private final SeverityRepository repository;

    public List<Severity> listAllSeveritys() {
        return repository
                .findAll();
    }

    public List<Severity> listSeveritysActive() {
        return repository
                .findAllByStatusTrue();
    }

    public Severity listSeverityById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Severity saveSeverity(RequestSeverityDTO severityDTO) {
        Severity severity = new Severity(severityDTO);

        repository.save(severity);
        return severity;
    }

    @Transactional
    public Severity editSeverity(UpdateSeverityDTO severityDTO) {
        Severity severity = repository
                .findById(severityDTO.getIdSeverity())
                .orElseThrow(EntityNotFoundException::new);

        severity.setUpdatedSeverity(severityDTO);
        return severity;
    }

    @Transactional
    public Severity editSeverityStatus(Long id) {
        Severity severity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        severity.setStatus(!severity.getStatus());

        return severity;
    }

    @Transactional
    public void excludeSeverity(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
