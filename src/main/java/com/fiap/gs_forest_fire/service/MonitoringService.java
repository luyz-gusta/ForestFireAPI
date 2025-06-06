package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.monitoring.RequestMonitoringDTO;
import com.fiap.gs_forest_fire.domain.dto.monitoring.UpdateMonitoringDTO;
import com.fiap.gs_forest_fire.domain.entities.Monitoring;
import com.fiap.gs_forest_fire.domain.entities.Drone;
import com.fiap.gs_forest_fire.repositories.MonitoringRepository;
import com.fiap.gs_forest_fire.repositories.DroneRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonitoringService {
    private final MonitoringRepository repository;
    private final DroneRepository droneRepository;

    public List<Monitoring> listAllMonitorings() {
        return repository
                .findAll();
    }

    public Monitoring listMonitoringById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Monitoring saveMonitoring(RequestMonitoringDTO monitoringDTO) {
        Drone drone = droneRepository.findById(monitoringDTO.getIdDrone()).orElseThrow(EntityNotFoundException::new);
        Monitoring monitoring = new Monitoring(monitoringDTO, drone);

        repository.save(monitoring);
        return monitoring;
    }

    @Transactional
    public Monitoring editMonitoring(UpdateMonitoringDTO monitoringDTO) {
        Drone drone = droneRepository.findById(monitoringDTO.getIdDrone()).orElseThrow(EntityNotFoundException::new);
        Monitoring monitoring = repository
                .findById(monitoringDTO.getIdMonitoring())
                .orElseThrow(EntityNotFoundException::new);

        monitoring.setUpdatedMonitoring(monitoringDTO, drone);
        return monitoring;
    }

    @Transactional
    public void excludeMonitoring(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
