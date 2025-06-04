package com.fiap.gs_forest_fire.domain.entities;

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
    @Column(name = "id_severity", nullable = false)
    private long idSeverity;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "alert_type", nullable = false)
    private Object alertType;

    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    public Alert() {
    }

    public Alert(long idAlert, long idSeverity, String description, Object alertType, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idAlert = idAlert;
        this.idSeverity = idSeverity;
        this.description = description;
        this.alertType = alertType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
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

    public long getIdSeverity() {
        return idSeverity;
    }

    public void setIdSeverity(long idSeverity) {
        this.idSeverity = idSeverity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getAlertType() {
        return alertType;
    }

    public void setAlertType(Object alertType) {
        this.alertType = alertType;
    }
}
