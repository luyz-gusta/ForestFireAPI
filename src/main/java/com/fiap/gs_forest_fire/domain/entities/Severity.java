package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.severity.RequestSeverityDTO;
import com.fiap.gs_forest_fire.domain.dto.severity.UpdateSeverityDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa o nível de severidade de alertas no sistema.
 * Esta classe é responsável por classificar a gravidade dos alertas de queimadas,
 * utilizando cores e nomes para identificar diferentes níveis de risco.
 */
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
    private Boolean status;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    /**
     * Construtor padrão da classe Severity.
     */
    public Severity() {
    }

    /**
     * Construtor completo da classe Severity.
     * @param idSeverity ID do nível de severidade
     * @param name Nome do nível de severidade
     * @param color Cor representativa do nível
     * @param status Status de ativação do nível
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
    public Severity(long idSeverity, String name, String color, Boolean status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idSeverity = idSeverity;
        this.name = name;
        this.color = color;
        this.status = true;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Construtor que cria um nível de severidade a partir de um DTO de requisição.
     * @param severityDTO DTO contendo os dados do nível de severidade
     */
    public Severity(RequestSeverityDTO severityDTO) {
        this.name = severityDTO.getName();
        this.color = severityDTO.getColor();
        this.status = true;
    }

    /**
     * Atualiza os dados do nível de severidade com base em um DTO de atualização.
     * @param severityDTO DTO contendo os novos dados do nível de severidade
     */
    public void setUpdatedSeverity(UpdateSeverityDTO severityDTO){
        this.name = severityDTO.getName();
        this.color = severityDTO.getColor();
        this.status = severityDTO.getStatus();
    }

    /**
     * Retorna o ID do nível de severidade.
     * @return ID único do nível de severidade
     */
    public long getIdSeverity() {
        return idSeverity;
    }

    /**
     * Define o ID do nível de severidade.
     * @param idSeverity Novo ID do nível de severidade
     */
    public void setIdSeverity(long idSeverity) {
        this.idSeverity = idSeverity;
    }

    /**
     * Retorna o nome do nível de severidade.
     * @return Nome descritivo do nível
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do nível de severidade.
     * @param name Novo nome do nível
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a cor representativa do nível de severidade.
     * @return Cor do nível de severidade
     */
    public String getColor() {
        return color;
    }

    /**
     * Define a cor do nível de severidade.
     * @param color Nova cor do nível
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retorna o status de ativação do nível de severidade.
     * @return Status atual (ativo/inativo)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Define o status de ativação do nível de severidade.
     * @param status Novo status de ativação
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação do nível de severidade
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
     * @return Data de atualização do nível de severidade
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
