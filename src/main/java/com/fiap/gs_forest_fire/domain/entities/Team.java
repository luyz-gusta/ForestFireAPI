package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.team.RequestTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.team.UpdateTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.UpdateUserDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa uma equipe de combate a incêndios no sistema.
 * Esta classe gerencia informações sobre equipes operacionais, incluindo
 * seus membros, veículos, localização e status operacional.
 */
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
    private String status;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;
    @OneToOne
    @JoinColumn(name = "id_login")
    private Login login;

    /**
     * Construtor padrão da classe Team.
     */
    public Team() {}

    /**
     * Construtor completo da classe Team.
     * @param idTeam ID da equipe
     * @param login Credenciais de acesso da equipe
     * @param name Nome da equipe
     * @param codName Código identificador da equipe
     * @param locationName Localização base da equipe
     * @param lastAccess Último acesso ao sistema
     * @param quantityMembers Quantidade de membros
     * @param quantityVehicle Quantidade de veículos
     * @param status Status operacional da equipe
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
    public Team(long idTeam, Login login, String name, String codName, String locationName, Timestamp lastAccess, int quantityMembers, int quantityVehicle, String status, Timestamp dateCreated, Timestamp dateUpdated) {
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

    /**
     * Construtor que cria uma equipe a partir de um DTO de requisição.
     * @param teamDTO DTO contendo os dados da equipe
     * @param login Credenciais de acesso da equipe
     */
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

    /**
     * Atualiza os dados da equipe com base em um DTO de atualização.
     * @param teamDTO DTO contendo os novos dados da equipe
     */
    public void setUpdatedTeam(UpdateTeamDTO teamDTO) {
        this.name = teamDTO.getName();
        this.codName = teamDTO.getCodName();
        this.locationName = teamDTO.getLocationName();
        this.lastAccess = teamDTO.getLastAccess();
        this.quantityMembers = teamDTO.getQuantityMembers();
        this.quantityVehicle = teamDTO.getQuantityVehicle();
        this.status = teamDTO.getStatus();
    }

    /**
     * Retorna o ID da equipe.
     * @return ID único da equipe
     */
    public long getIdTeam() {
        return idTeam;
    }

    /**
     * Define o ID da equipe.
     * @param idTeam Novo ID da equipe
     */
    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    /**
     * Retorna as credenciais de acesso da equipe.
     * @return Objeto Login associado
     */
    public Login getLogin() {
        return login;
    }

    /**
     * Define as credenciais de acesso da equipe.
     * @param login Novas credenciais de acesso
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * Retorna o nome da equipe.
     * @return Nome da equipe
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da equipe.
     * @param name Novo nome da equipe
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o código identificador da equipe.
     * @return Código da equipe
     */
    public String getCodName() {
        return codName;
    }

    /**
     * Define o código identificador da equipe.
     * @param codName Novo código da equipe
     */
    public void setCodName(String codName) {
        this.codName = codName;
    }

    /**
     * Retorna a localização base da equipe.
     * @return Nome da localização
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Define a localização base da equipe.
     * @param locationName Nova localização
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Retorna o timestamp do último acesso da equipe.
     * @return Data e hora do último acesso
     */
    public Timestamp getLastAccess() {
        return lastAccess;
    }

    /**
     * Define o timestamp do último acesso da equipe.
     * @param lastAccess Nova data e hora de acesso
     */
    public void setLastAccess(Timestamp lastAccess) {
        this.lastAccess = lastAccess;
    }

    /**
     * Retorna a quantidade de membros da equipe.
     * @return Número de membros
     */
    public int getQuantityMembers() {
        return quantityMembers;
    }

    /**
     * Define a quantidade de membros da equipe.
     * @param quantityMembers Nova quantidade de membros
     */
    public void setQuantityMembers(int quantityMembers) {
        this.quantityMembers = quantityMembers;
    }

    /**
     * Retorna a quantidade de veículos da equipe.
     * @return Número de veículos
     */
    public int getQuantityVehicle() {
        return quantityVehicle;
    }

    /**
     * Define a quantidade de veículos da equipe.
     * @param quantityVehicle Nova quantidade de veículos
     */
    public void setQuantityVehicle(int quantityVehicle) {
        this.quantityVehicle = quantityVehicle;
    }

    /**
     * Retorna o status operacional da equipe.
     * @return Status atual da equipe
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status operacional da equipe.
     * @param status Novo status da equipe
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação da equipe
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
     * @return Data de atualização da equipe
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
}
