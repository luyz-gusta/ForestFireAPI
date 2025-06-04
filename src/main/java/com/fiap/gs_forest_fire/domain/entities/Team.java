package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.team.RequestTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.UpdateTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.UpdateUserDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_team", schema = "db_gs_queimadas", catalog = "")
public class Team {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_team", nullable = false)
    private long idTeam;

    @Basic
    @Column(name = "name", nullable = false, length = 120)
    private String name;
    @Basic
    @Column(name = "cod_name", nullable = false, length = 120)
    private String codName;
    @Basic
    @Column(name = "location_name", nullable = false, length = 200)
    private String locationName;
    @Basic
    @Column(name = "last_access", nullable = true)
    private Timestamp lastAccess;
    @Basic
    @Column(name = "quantity_members", nullable = false)
    private int quantityMembers;
    @Basic
    @Column(name = "quantity_vehicle", nullable = false)
    private int quantityVehicle;
    @Basic
    @Column(name = "status", nullable = false)
    private Object status;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;
    @OneToOne
    @JoinColumn(name = "id_login")
    private Login login;

    public Team() {}

    public Team(long idTeam, Login login, String name, String codName, String locationName, Timestamp lastAccess, int quantityMembers, int quantityVehicle, Object status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idTeam = idTeam;
        this.login = login;
        this.name = name;
        this.codName = codName;
        this.locationName = locationName;
        this.lastAccess = lastAccess;
        this.quantityMembers = quantityMembers;
        this.quantityVehicle = quantityVehicle;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Team(RequestTeamDTO teamDTO, Login login){
        this.login = login;
        this.name = teamDTO.getName();
        this.codName = teamDTO.getCodName();
        this.locationName = teamDTO.getLocationName();
        this.lastAccess = teamDTO.getLastAccess();
        this.quantityMembers = teamDTO.getQuantityMembers();
        this.quantityVehicle = teamDTO.getQuantityVehicle();
        this.status = teamDTO.getStatus();
    }

    public void setUpdatedTeam(UpdateTeamDTO teamDTO) {
        this.name = teamDTO.getName();
        this.codName = teamDTO.getCodName();
        this.locationName = teamDTO.getLocationName();
        this.lastAccess = teamDTO.getLastAccess();
        this.quantityMembers = teamDTO.getQuantityMembers();
        this.quantityVehicle = teamDTO.getQuantityVehicle();
        this.status = teamDTO.getStatus();
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Timestamp getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Timestamp lastAccess) {
        this.lastAccess = lastAccess;
    }

    public int getQuantityMembers() {
        return quantityMembers;
    }

    public void setQuantityMembers(int quantityMembers) {
        this.quantityMembers = quantityMembers;
    }

    public int getQuantityVehicle() {
        return quantityVehicle;
    }

    public void setQuantityVehicle(int quantityVehicle) {
        this.quantityVehicle = quantityVehicle;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
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
