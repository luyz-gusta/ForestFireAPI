package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.operation.RequestOperationDTO;
import com.fiap.gs_forest_fire.domain.dto.operation.UpdateOperationDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa uma operação de combate a incêndios no sistema.
 * Esta classe gerencia informações sobre operações de combate a queimadas,
 * incluindo detalhes sobre equipes envolvidas, área afetada, evacuados e cronograma.
 */
@Entity
@Table(name = "tb_operation", schema = "db_gs_queimadas", catalog = "")
public class Operation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_operation", nullable = false)
    private long idOperation;
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

    @ManyToOne
    @JoinColumn(name = "id_severity")
    private Severity severity;

    /**
     * Construtor padrão da classe Operation.
     */
    public Operation() {
    }

    /**
     * Construtor completo da classe Operation.
     * @param idOperation ID da operação
     * @param idSeverity ID do nível de severidade
     * @param name Nome da operação
     * @param codName Código da operação
     * @param description Descrição detalhada
     * @param startTime Horário de início
     * @param endTime Horário de término
     * @param quantityTeams Quantidade de equipes
     * @param affectedArea Área afetada
     * @param evacuees Número de evacuados
     * @param status Status da operação
     * @param dateCreated Data de criação
     * @param dateUpdated Data de atualização
     */
    public Operation(long idOperation, long idSeverity, String name, String codName, String description, Timestamp startTime, Timestamp endTime, int quantityTeams, String affectedArea, Integer evacuees, Boolean status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idOperation = idOperation;
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

    /**
     * Construtor que cria uma operação a partir de um DTO de requisição.
     * @param operationDTO DTO contendo os dados da operação
     * @param severity Nível de severidade da operação
     */
    public Operation(RequestOperationDTO operationDTO, Severity severity) {
        this.severity = severity;
        this.name = operationDTO.getName();
        this.codName = operationDTO.getCodName();
        this.description = operationDTO.getDescription();
        this.startTime = operationDTO.getStartTime();
        this.endTime = operationDTO.getEndTime();
        this.quantityTeams = operationDTO.getQuantityTeams();
        this.affectedArea = operationDTO.getAffectedArea();
        this.evacuees = operationDTO.getEvacuees();
        this.status = true;
    }

    /**
     * Atualiza os dados da operação com base em um DTO de atualização.
     * @param operationDTO DTO contendo os novos dados da operação
     * @param severity Novo nível de severidade da operação
     */
    public void setUpdatedOperation(UpdateOperationDTO operationDTO, Severity severity){
        this.severity = severity;
        this.name = operationDTO.getName();
        this.codName = operationDTO.getCodName();
        this.description = operationDTO.getDescription();
        this.startTime = operationDTO.getStartTime();
        this.endTime = operationDTO.getEndTime();
        this.quantityTeams = operationDTO.getQuantityTeams();
        this.affectedArea = operationDTO.getAffectedArea();
        this.evacuees = operationDTO.getEvacuees();
        this.status = true;
    }

    /**
     * Retorna o ID da operação.
     * @return ID único da operação
     */
    public long getIdOperation() {
        return idOperation;
    }

    /**
     * Define o ID da operação.
     * @param idOperation Novo ID da operação
     */
    public void setIdOperation(long idOperation) {
        this.idOperation = idOperation;
    }

    /**
     * Retorna o nível de severidade da operação.
     * @return Objeto Severity associado à operação
     */
    public Severity getIdSeverity() {
        return severity;
    }

    /**
     * Define o nível de severidade da operação.
     * @param severity Novo nível de severidade
     */
    public void setIdSeverity(Severity severity) {
        this.severity = severity;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da operação.
     * @param name Novo nome da operação
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o código da operação.
     * @return Código identificador da operação
     */
    public String getCodName() {
        return codName;
    }

    /**
     * Define o código da operação.
     * @param codName Novo código da operação
     */
    public void setCodName(String codName) {
        this.codName = codName;
    }

    /**
     * Retorna a descrição da operação.
     * @return Descrição detalhada da operação
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição da operação.
     * @param description Nova descrição da operação
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o horário de início da operação.
     * @return Data e hora de início
     */
    public Timestamp getStartTime() {
        return startTime;
    }

    /**
     * Define o horário de início da operação.
     * @param startTime Nova data e hora de início
     */
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    /**
     * Retorna o horário de término da operação.
     * @return Data e hora de término
     */
    public Timestamp getEndTime() {
        return endTime;
    }

    /**
     * Define o horário de término da operação.
     * @param endTime Nova data e hora de término
     */
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    /**
     * Retorna a quantidade de equipes envolvidas na operação.
     * @return Número de equipes
     */
    public int getQuantityTeams() {
        return quantityTeams;
    }

    /**
     * Define a quantidade de equipes envolvidas na operação.
     * @param quantityTeams Nova quantidade de equipes
     */
    public void setQuantityTeams(int quantityTeams) {
        this.quantityTeams = quantityTeams;
    }

    /**
     * Retorna a área afetada pela queimada.
     * @return Descrição da área afetada
     */
    public String getAffectedArea() {
        return affectedArea;
    }

    /**
     * Define a área afetada pela queimada.
     * @param affectedArea Nova descrição da área afetada
     */
    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }

    /**
     * Retorna o número de pessoas evacuadas.
     * @return Quantidade de evacuados
     */
    public Integer getEvacuees() {
        return evacuees;
    }

    /**
     * Define o número de pessoas evacuadas.
     * @param evacuees Nova quantidade de evacuados
     */
    public void setEvacuees(Integer evacuees) {
        this.evacuees = evacuees;
    }

    /**
     * Retorna o status da operação.
     * @return Status atual (ativa/inativa)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Define o status da operação.
     * @param status Novo status da operação
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação da operação
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
     * @return Data de atualização da operação
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
