package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.drone.RequestDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.drone.UpdateDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_drone", schema = "db_gs_queimadas", catalog = "")
public class Drone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_drone", nullable = false)
    private long idDrone;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "cod", nullable = false, length = 100)
    private String cod;
    @Basic
    @Column(name = "battery", nullable = false, length = 50)
    private String battery;
    @Basic
    @Column(name = "location", nullable = true, length = -1)
    private String location;
    @Basic
    @Column(name = "status", nullable = false)
    private String status;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    public Drone() {
    }

    public Drone(long idDrone, String name, String cod, String battery, String location, String status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idDrone = idDrone;
        this.name = name;
        this.cod = cod;
        this.battery = battery;
        this.location = location;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Drone(RequestDroneDTO droneDTO){
        this.name = droneDTO.getName();
        this.cod = droneDTO.getCod();
        this.battery = droneDTO.getBattery();
        this.location = droneDTO.getLocation();
        this.status = droneDTO.getStatus();
    }

    public void setUpdatedDrone(UpdateDroneDTO equipmentDTO) {
        this.name = equipmentDTO.getName();
        this.cod = equipmentDTO.getCod();
        this.battery = equipmentDTO.getBattery();
        this.location = equipmentDTO.getLocation();
        this.status = equipmentDTO.getStatus();
    }

    public long getIdDrone() {
        return idDrone;
    }

    public void setIdDrone(long idDrone) {
        this.idDrone = idDrone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
