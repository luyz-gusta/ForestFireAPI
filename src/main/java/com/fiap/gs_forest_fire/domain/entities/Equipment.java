package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.equipment.RequestEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.team.UpdateTeamDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_equipment", schema = "db_gs_queimadas", catalog = "")
public class Equipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_equipment", nullable = false)
    private long idEquipment;
    @Basic
    @Column(name = "name", nullable = false, length = 120)
    private String name;
    @Basic
    @Column(name = "color", nullable = false, length = 50)
    private String color;
    @Basic
    @Column(name = "total_quantity", nullable = false)
    private int totalQuantity;
    @Basic
    @Column(name = "quantity_used", nullable = false)
    private int quantityUsed;
    @Basic
    @Column(name = "status", nullable = true)
    private Boolean status;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    public Equipment() {
    }

    public Equipment(long idEquipment, String name, String color, int totalQuantity, int quantityUsed, Boolean status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idEquipment = idEquipment;
        this.name = name;
        this.color = color;
        this.totalQuantity = totalQuantity;
        this.quantityUsed = quantityUsed;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Equipment(RequestEquipmentDTO equipmentDTO) {
        this.name = equipmentDTO.getName();
        this.color = equipmentDTO.getColor();
        this.totalQuantity = equipmentDTO.getTotalQuantity();
        this.quantityUsed = equipmentDTO.getQuantityUsed();
    }

    public void setUpdatedEquipment(UpdateEquipmentDTO equipmentDTO) {
        this.name = equipmentDTO.getName();
        this.color = equipmentDTO.getColor();
        this.totalQuantity = equipmentDTO.getTotalQuantity();
        this.quantityUsed = equipmentDTO.getQuantityUsed();
        this.status = equipmentDTO.getStatus();
    }

    public long getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(long idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
