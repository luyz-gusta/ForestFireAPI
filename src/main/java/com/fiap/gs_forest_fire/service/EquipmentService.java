package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.equipment.RequestEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import com.fiap.gs_forest_fire.domain.entities.Equipment;
import com.fiap.gs_forest_fire.repositories.EquipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentService {
    private final EquipmentRepository repository;

    public List<Equipment> listAllEquipments() {
        return repository
                .findAll();
    }

    public List<Equipment> listEquipmentsActive() {
        return repository
                .findAllByStatusTrue();
    }

    public Equipment listEquipmentById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Equipment saveEquipment(RequestEquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment(equipmentDTO);

        repository.save(equipment);
        return equipment;
    }

    @Transactional
    public Equipment editEquipment(UpdateEquipmentDTO equipmentDTO) {
        Equipment equipment = repository
                .findById(equipmentDTO.getIdEquipment())
                .orElseThrow(EntityNotFoundException::new);

        equipment.setUpdatedEquipment(equipmentDTO);
        return equipment;
    }

    @Transactional
    public Equipment editEquipmentStatus(Long id) {
        Equipment equipment = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        equipment.setStatus(!equipment.getStatus());

        return equipment;
    }

    @Transactional
    public void excludeEquipment(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
