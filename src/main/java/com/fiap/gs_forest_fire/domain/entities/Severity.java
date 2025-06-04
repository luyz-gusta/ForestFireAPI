package com.fiap.gs_forest_fire.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_severity", schema = "db_gs_queimadas", catalog = "")
public class Severity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_severity", nullable = false)
    private long idSeverity;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "color", nullable = false, length = 50)
    private String color;
    @Basic
    @Column(name = "status", nullable = true)
    private Byte status;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    public Severity() {
    }

    public Severity(long idSeverity, String name, String color, Byte status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idSeverity = idSeverity;
        this.name = name;
        this.color = color;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public long getIdSeverity() {
        return idSeverity;
    }

    public void setIdSeverity(long idSeverity) {
        this.idSeverity = idSeverity;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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
