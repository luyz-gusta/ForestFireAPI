package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.alert.RequestAlertDTO;
import com.fiap.gs_forest_fire.domain.dto.alert.UpdateAlertDTO;
import com.fiap.gs_forest_fire.domain.entities.Alert;
import com.fiap.gs_forest_fire.domain.entities.Severity;
import com.fiap.gs_forest_fire.repositories.AlertRepository;
import com.fiap.gs_forest_fire.repositories.SeverityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertService {
    private final AlertRepository repository;
    private final SeverityRepository severityRepository;

    public List<Alert> listAllAlerts() {
        return repository
                .findAll();
    }

    public Alert listAlertById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Alert saveAlert(RequestAlertDTO alertDTO) {
        Severity severity = severityRepository.findById(alertDTO.getIdSeverity()).orElseThrow(EntityNotFoundException::new);
        Alert alert = new Alert(alertDTO, severity);

        repository.save(alert);
        return alert;
    }

    @Transactional
    public Alert editAlert(UpdateAlertDTO alertDTO) {
        Severity severity = severityRepository.findById(alertDTO.getIdSeverity()).orElseThrow(EntityNotFoundException::new);
        Alert alert = repository
                .findById(alertDTO.getIdAlert())
                .orElseThrow(EntityNotFoundException::new);

        alert.setUpdatedAlert(alertDTO, severity);
        return alert;
    }

    @Transactional
    public void excludeAlert(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
