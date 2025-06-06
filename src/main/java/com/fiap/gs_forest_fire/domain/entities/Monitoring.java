package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.monitoring.RequestMonitoringDTO;
import com.fiap.gs_forest_fire.domain.dto.monitoring.UpdateMonitoringDTO;
import com.fiap.gs_forest_fire.domain.dto.severity.UpdateSeverityDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

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

    public Monitoring() {
    }

    public Monitoring(long idMonitoring, Drone drone, Double temperature, Double humidity, Double airQuality, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idMonitoring = idMonitoring;
        this.drone = drone;
        this.temperature = temperature;
        this.humidity = humidity;
        this.airQuality = airQuality;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Monitoring(RequestMonitoringDTO monitoringDTO, Drone drone){
        this.drone = drone;
        this.temperature = monitoringDTO.getTemperature();
        this.humidity = monitoringDTO.getHumidity();
        this.airQuality = monitoringDTO.getAirQuality();
    }

    public void setUpdatedMonitoring(UpdateMonitoringDTO monitoringDTO, Drone drone){
        this.drone = drone;
        this.temperature = monitoringDTO.getTemperature();
        this.humidity = monitoringDTO.getHumidity();
        this.airQuality = monitoringDTO.getAirQuality();
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
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

    public long getIdMonitoring() {
        return idMonitoring;
    }

    public void setIdMonitoring(long idMonitoring) {
        this.idMonitoring = idMonitoring;
    }


    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(Double airQuality) {
        this.airQuality = airQuality;
    }
}
