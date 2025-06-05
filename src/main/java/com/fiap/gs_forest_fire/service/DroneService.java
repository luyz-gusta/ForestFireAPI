package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.drone.RequestDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.drone.UpdateDroneDTO;
import com.fiap.gs_forest_fire.domain.entities.Drone;
import com.fiap.gs_forest_fire.repositories.DroneRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DroneService {
    private final DroneRepository repository;

    public List<Drone> listAllDrones() {
        return repository
                .findAll();
    }

    public List<Drone> listDronesActive() {
        return repository
                .findAllByStatusTrue();
    }

    public Drone listDroneById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Drone saveDrone(RequestDroneDTO droneDTO) {
        Drone drone = new Drone(droneDTO);

        repository.save(drone);
        return drone;
    }

    @Transactional
    public Drone editDrone(UpdateDroneDTO droneDTO) {
        Drone drone = repository
                .findById(droneDTO.getIdDrone())
                .orElseThrow(EntityNotFoundException::new);

        drone.setUpdatedDrone(droneDTO);
        return drone;
    }

    @Transactional
    public Drone editDroneStatus(Long id, String status) {
        Drone drone = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        drone.setStatus(status);

        return drone;
    }

    @Transactional
    public void excludeDrone(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
