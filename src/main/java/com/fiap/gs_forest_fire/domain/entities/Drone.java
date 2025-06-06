package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.drone.RequestDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.drone.UpdateDroneDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa um drone no sistema de monitoramento de queimadas.
 * Esta classe é responsável por armazenar informações sobre os drones utilizados no monitoramento,
 * incluindo seu status operacional, localização, nível de bateria e identificação.
 */
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

    /**
     * Construtor padrão da classe Drone.
     */
    public Drone() {
    }

    /**
     * Construtor completo da classe Drone.
     * @param idDrone ID do drone
     * @param name Nome do drone
     * @param cod Código de identificação do drone
     * @param battery Nível de bateria do drone
     * @param location Localização atual do drone
     * @param status Status operacional do drone
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
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

    /**
     * Construtor que cria um drone a partir de um DTO de requisição.
     * @param droneDTO DTO contendo os dados do drone
     */
    public Drone(RequestDroneDTO droneDTO){
        this.name = droneDTO.getName();
        this.cod = droneDTO.getCod();
        this.battery = droneDTO.getBattery();
        this.location = droneDTO.getLocation();
        this.status = droneDTO.getStatus();
    }

    /**
     * Atualiza os dados do drone com base em um DTO de atualização.
     * @param equipmentDTO DTO contendo os novos dados do drone
     */
    public void setUpdatedDrone(UpdateDroneDTO equipmentDTO) {
        this.name = equipmentDTO.getName();
        this.cod = equipmentDTO.getCod();
        this.battery = equipmentDTO.getBattery();
        this.location = equipmentDTO.getLocation();
        this.status = equipmentDTO.getStatus();
    }

    /**
     * Retorna o ID do drone.
     * @return ID único do drone
     */
    public long getIdDrone() {
        return idDrone;
    }

    /**
     * Define o ID do drone.
     * @param idDrone Novo ID do drone
     */
    public void setIdDrone(long idDrone) {
        this.idDrone = idDrone;
    }

    /**
     * Retorna o nome do drone.
     * @return Nome do drone
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do drone.
     * @param name Novo nome do drone
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o código de identificação do drone.
     * @return Código do drone
     */
    public String getCod() {
        return cod;
    }

    /**
     * Define o código de identificação do drone.
     * @param cod Novo código do drone
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Retorna o nível de bateria do drone.
     * @return Nível de bateria atual
     */
    public String getBattery() {
        return battery;
    }

    /**
     * Define o nível de bateria do drone.
     * @param battery Novo nível de bateria
     */
    public void setBattery(String battery) {
        this.battery = battery;
    }

    /**
     * Retorna a localização atual do drone.
     * @return Localização geográfica do drone
     */
    public String getLocation() {
        return location;
    }

    /**
     * Define a localização do drone.
     * @param location Nova localização do drone
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Retorna o status operacional do drone.
     * @return Status atual do drone
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status operacional do drone.
     * @param status Novo status do drone
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna a data de criação do registro do drone.
     * @return Data de criação do registro
     */
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    /**
     * Define a data de criação do registro do drone.
     * @param dateCreated Nova data de criação
     */
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Retorna a data de atualização do registro do drone.
     * @return Data de atualização do registro
     */
    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    /**
     * Define a data de atualização do registro do drone.
     * @param dateUpdated Nova data de atualização
     */
    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
