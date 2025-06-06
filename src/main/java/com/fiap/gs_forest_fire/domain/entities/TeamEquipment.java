package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.teamEquipment.RequestTeamEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.teamEquipment.UpdateTeamEquipmentDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa a associação entre equipes e equipamentos no sistema.
 * Esta classe gerencia o relacionamento muitos-para-muitos entre equipes e seus equipamentos,
 * permitindo o controle dos recursos disponíveis para cada equipe de combate a incêndios.
 */
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

    /**
     * Construtor padrão da classe TeamEquipment.
     */
    public TeamEquipment() {
    }

    /**
     * Construtor completo da classe TeamEquipment.
     * @param idTeamEquipment ID da associação equipe-equipamento
     * @param team Equipe associada
     * @param equipment Equipamento associado
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
    public TeamEquipment(long idTeamEquipment, Team team, Equipment equipment, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idTeamEquipment = idTeamEquipment;
        this.team = team;
        this.equipment = equipment;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Construtor que cria uma associação equipe-equipamento.
     * @param team Equipe a ser associada
     * @param equipment Equipamento a ser associado
     */
    public TeamEquipment(Team team, Equipment equipment) {
        this.team = team;
        this.equipment = equipment;
    }

    /**
     * Atualiza a associação entre equipe e equipamento.
     * @param team Nova equipe a ser associada
     * @param equipment Novo equipamento a ser associado
     */
    public void setUpdateTeamEquipment(Team team, Equipment equipment) {
        this.team = team;
        this.equipment = equipment;
    }

    /**
     * Retorna a equipe associada.
     * @return Objeto Team associado
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Define a equipe associada.
     * @param team Nova equipe a ser associada
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Retorna o equipamento associado.
     * @return Objeto Equipment associado
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * Define o equipamento associado.
     * @param equipment Novo equipamento a ser associado
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * Retorna o ID da associação equipe-equipamento.
     * @return ID único da associação
     */
    public long getIdTeamEquipment() {
        return idTeamEquipment;
    }

    /**
     * Define o ID da associação equipe-equipamento.
     * @param idTeamEquipment Novo ID da associação
     */
    public void setIdTeamEquipment(long idTeamEquipment) {
        this.idTeamEquipment = idTeamEquipment;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação da associação
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
     * @return Data de atualização da associação
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
