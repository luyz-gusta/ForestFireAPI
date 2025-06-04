package com.fiap.gs_forest_fire.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_team_equipment", schema = "db_gs_queimadas", catalog = "")
public class TeamEquipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_team_equipment", nullable = false)
    private long idTeamEquipment;
    @Basic
    @Column(name = "id_team", nullable = false)
    private long idTeam;
    @Basic
    @Column(name = "id_equipment", nullable = false)
    private long idEquipment;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    public TeamEquipment() {
    }

    public TeamEquipment(long idTeamEquipment, long idTeam, long idEquipment, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idTeamEquipment = idTeamEquipment;
        this.idTeam = idTeam;
        this.idEquipment = idEquipment;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public long getIdTeamEquipment() {
        return idTeamEquipment;
    }

    public void setIdTeamEquipment(long idTeamEquipment) {
        this.idTeamEquipment = idTeamEquipment;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public long getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(long idEquipment) {
        this.idEquipment = idEquipment;
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
