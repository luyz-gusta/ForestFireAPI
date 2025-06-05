package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.teamEquipment.RequestTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.teamEquipment.UpdateTeamEquipmentDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_team_equipment", schema = "db_gs_queimadas", catalog = "")
public class TeamEquipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_team_equipment", nullable = false)
    private long idTeamEquipment;

    @ManyToOne
    @JoinColumn(name = "id_team", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "id_equipment", nullable = false)
    private Equipment equipment;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    public TeamEquipment() {
    }

    public TeamEquipment(long idTeamEquipment, Team team, Equipment equipment, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idTeamEquipment = idTeamEquipment;
        this.team = team;
        this.equipment = equipment;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public TeamEquipment(Team team, Equipment equipment) {
        this.team = team;
        this.equipment = equipment;
    }

    public void setUpdateTeamEquipment(Team team, Equipment equipment) {
        this.team = team;
        this.equipment = equipment;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public long getIdTeamEquipment() {
        return idTeamEquipment;
    }

    public void setIdTeamEquipment(long idTeamEquipment) {
        this.idTeamEquipment = idTeamEquipment;
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
