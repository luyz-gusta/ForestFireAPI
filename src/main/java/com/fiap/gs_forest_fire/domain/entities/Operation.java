package com.fiap.gs_forest_fire.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_operation", schema = "db_gs_queimadas", catalog = "")
public class Operation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_operation", nullable = false)
    private long idOperation;
    @Basic
    @Column(name = "id_severity", nullable = false)
    private long idSeverity;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "cod_name", nullable = false, length = 100)
    private String codName;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;
    @Basic
    @Column(name = "end_time", nullable = true)
    private Timestamp endTime;
    @Basic
    @Column(name = "quantity_teams", nullable = false)
    private int quantityTeams;
    @Basic
    @Column(name = "affected_area", nullable = true, length = 255)
    private String affectedArea;
    @Basic
    @Column(name = "evacuees", nullable = true)
    private Integer evacuees;
    @Basic
    @Column(name = "status", nullable = true)
    private Boolean status;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    public Operation() {
    }

    public Operation(long idOperation, long idSeverity, String name, String codName, String description, Timestamp startTime, Timestamp endTime, int quantityTeams, String affectedArea, Integer evacuees, Boolean status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idOperation = idOperation;
        this.idSeverity = idSeverity;
        this.name = name;
        this.codName = codName;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.quantityTeams = quantityTeams;
        this.affectedArea = affectedArea;
        this.evacuees = evacuees;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(long idOperation) {
        this.idOperation = idOperation;
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

    public String getCodName() {
        return codName;
    }

    public void setCodName(String codName) {
        this.codName = codName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getQuantityTeams() {
        return quantityTeams;
    }

    public void setQuantityTeams(int quantityTeams) {
        this.quantityTeams = quantityTeams;
    }

    public String getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }

    public Integer getEvacuees() {
        return evacuees;
    }

    public void setEvacuees(Integer evacuees) {
        this.evacuees = evacuees;
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
