package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.monitoring.RequestMonitoringDTO;
import com.fiap.gs_forest_fire.domain.dto.monitoring.UpdateMonitoringDTO;
import com.fiap.gs_forest_fire.domain.dto.severity.UpdateSeverityDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa o monitoramento ambiental realizado por drones.
 * Esta classe armazena dados de temperatura, umidade e qualidade do ar coletados durante o monitoramento de áreas.
 */
@Entity
@Table(name = "tb_monitoring", schema = "db_gs_queimadas", catalog = "")
public class Monitoring {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_monitoring", nullable = false)
    private long idMonitoring;
    @Basic
    @Column(name = "temperature", nullable = false, precision = 2)
    private Double temperature;
    @Basic
    @Column(name = "humidity", nullable = false, precision = 2)
    private Double humidity;
    @Basic
    @Column(name = "air_quality", nullable = false, precision = 2)
    private Double airQuality;

    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    @ManyToOne
    @JoinColumn(name = "id_drone")
    private Drone drone;

    /**
     * Construtor padrão da classe Monitoring.
     */
    public Monitoring() {
    }

    /**
     * Construtor completo da classe Monitoring.
     * @param idMonitoring ID do monitoramento
     * @param drone Drone que realizou o monitoramento
     * @param temperature Temperatura registrada
     * @param humidity Umidade registrada
     * @param airQuality Qualidade do ar registrada
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
    public Monitoring(long idMonitoring, Drone drone, Double temperature, Double humidity, Double airQuality, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idMonitoring = idMonitoring;
        this.drone = drone;
        this.temperature = temperature;
        this.humidity = humidity;
        this.airQuality = airQuality;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Construtor que cria um monitoramento a partir de um DTO de requisição.
     * @param monitoringDTO DTO contendo os dados do monitoramento
     * @param drone Drone que realizou o monitoramento
     */
    public Monitoring(RequestMonitoringDTO monitoringDTO, Drone drone){
        this.drone = drone;
        this.temperature = monitoringDTO.getTemperature();
        this.humidity = monitoringDTO.getHumidity();
        this.airQuality = monitoringDTO.getAirQuality();
    }

    /**
     * Atualiza os dados do monitoramento com base em um DTO de atualização.
     * @param monitoringDTO DTO contendo os novos dados do monitoramento
     * @param drone Novo drone associado ao monitoramento
     */
    public void setUpdatedMonitoring(UpdateMonitoringDTO monitoringDTO, Drone drone){
        this.drone = drone;
        this.temperature = monitoringDTO.getTemperature();
        this.humidity = monitoringDTO.getHumidity();
        this.airQuality = monitoringDTO.getAirQuality();
    }

    /**
     * Retorna o drone associado ao monitoramento.
     * @return Drone que realizou o monitoramento
     */
    public Drone getDrone() {
        return drone;
    }

    /**
     * Define o drone associado ao monitoramento.
     * @param drone Novo drone a ser associado
     */
    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação do monitoramento
     */
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    /**
     * Define a data de criação do registro.
     * @param dateCreated Nova data de criação
     */
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Retorna a data de atualização do registro.
     * @return Data de atualização do monitoramento
     */
    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    /**
     * Define a data de atualização do registro.
     * @param dateUpdated Nova data de atualização
     */
    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * Retorna o ID do monitoramento.
     * @return ID único do monitoramento
     */
    public long getIdMonitoring() {
        return idMonitoring;
    }

    /**
     * Define o ID do monitoramento.
     * @param idMonitoring Novo ID do monitoramento
     */
    public void setIdMonitoring(long idMonitoring) {
        this.idMonitoring = idMonitoring;
    }

    /**
     * Retorna a temperatura registrada.
     * @return Temperatura em graus Celsius
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * Define a temperatura registrada.
     * @param temperature Nova temperatura em graus Celsius
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * Retorna a umidade registrada.
     * @return Umidade relativa do ar em porcentagem
     */
    public Double getHumidity() {
        return humidity;
    }

    /**
     * Define a umidade registrada.
     * @param humidity Nova umidade relativa do ar em porcentagem
     */
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    /**
     * Retorna a qualidade do ar registrada.
     * @return Índice de qualidade do ar
     */
    public Double getAirQuality() {
        return airQuality;
    }

    /**
     * Define a qualidade do ar registrada.
     * @param airQuality Novo índice de qualidade do ar
     */
    public void setAirQuality(Double airQuality) {
        this.airQuality = airQuality;
    }
}
