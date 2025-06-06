package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.alert.RequestAlertDTO;
import com.fiap.gs_forest_fire.domain.dto.alert.UpdateAlertDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_alert", schema = "db_gs_queimadas", catalog = "")
public class Alert {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_alert", nullable = false)
    private long idAlert;

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "alert_type", nullable = false)
    private String alertType;

    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    @ManyToOne
    @JoinColumn(name = "id_severity")
    private Severity severity;

    public Alert() {
    }

    public Alert(long idAlert, Severity severity, String description, String alertType, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idAlert = idAlert;
        this.severity = severity;
        this.description = description;
        this.alertType = alertType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Alert(RequestAlertDTO alertDTO, Severity severity){
        this.severity = severity;
        this.description = alertDTO.getDescription();
        this.alertType = alertDTO.getAlertType();
    }

    public void setUpdatedAlert(UpdateAlertDTO alertDTO, Severity severity) {
        this.severity = severity;
        this.description = alertDTO.getDescription();
        this.alertType = alertDTO.getAlertType();
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

    public long getIdAlert() {
        return idAlert;
    }

    public void setIdAlert(long idAlert) {
        this.idAlert = idAlert;
    }

    public Severity getIdSeverity() {
        return severity;
    }

    public void setIdSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }
}
