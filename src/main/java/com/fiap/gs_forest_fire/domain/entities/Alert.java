package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.alert.RequestAlertDTO;
import com.fiap.gs_forest_fire.domain.dto.alert.UpdateAlertDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa um alerta no sistema de monitoramento de queimadas.
 * Esta classe é responsável por armazenar informações sobre alertas gerados durante o monitoramento,
 * incluindo sua descrição, tipo e nível de severidade.
 */
@Entity
@Table(name = "tb_alert", schema = "db_gs_queimadas", catalog = "")
public class Alert {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_alert", nullable = false)
    private long idAlert;

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    
    @Basic
    @Column(name = "alert_type", nullable = false)
    private String alertType;

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
     * Construtor padrão da classe Alert.
     */
    public Alert() {
    }

    /**
     * Construtor completo da classe Alert.
     * @param idAlert ID do alerta
     * @param severity Nível de severidade do alerta
     * @param description Descrição detalhada do alerta
     * @param alertType Tipo do alerta
     * @param dateCreated Data de criação do alerta
     * @param dateUpdated Data de atualização do alerta
     */
    public Alert(long idAlert, Severity severity, String description, String alertType, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idAlert = idAlert;
        this.severity = severity;
        this.description = description;
        this.alertType = alertType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Construtor que cria um alerta a partir de um DTO de requisição.
     * @param alertDTO DTO contendo os dados do alerta
     * @param severity Nível de severidade do alerta
     */
    public Alert(RequestAlertDTO alertDTO, Severity severity){
        this.severity = severity;
        this.description = alertDTO.getDescription();
        this.alertType = alertDTO.getAlertType();
    }

    /**
     * Atualiza os dados do alerta com base em um DTO de atualização.
     * @param alertDTO DTO contendo os novos dados do alerta
     * @param severity Novo nível de severidade do alerta
     */
    public void setUpdatedAlert(UpdateAlertDTO alertDTO, Severity severity) {
        this.severity = severity;
        this.description = alertDTO.getDescription();
        this.alertType = alertDTO.getAlertType();
    }

    /**
     * Retorna a data de criação do alerta.
     * @return Data de criação do registro
     */
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    /**
     * Define a data de criação do alerta.
     * @param dateCreated Nova data de criação
     */
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Retorna a data de atualização do alerta.
     * @return Data de atualização do registro
     */
    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    /**
     * Define a data de atualização do alerta.
     * @param dateUpdated Nova data de atualização
     */
    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * Retorna o ID do alerta.
     * @return ID único do alerta
     */
    public long getIdAlert() {
        return idAlert;
    }

    /**
     * Define o ID do alerta.
     * @param idAlert Novo ID do alerta
     */
    public void setIdAlert(long idAlert) {
        this.idAlert = idAlert;
    }

    /**
     * Retorna o nível de severidade do alerta.
     * @return Objeto Severity contendo informações sobre a severidade
     */
    public Severity getIdSeverity() {
        return severity;
    }

    /**
     * Define o nível de severidade do alerta.
     * @param severity Nova severidade do alerta
     */
    public void setIdSeverity(Severity severity) {
        this.severity = severity;
    }

    /**
     * Retorna a descrição do alerta.
     * @return Descrição detalhada do alerta
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição do alerta.
     * @param description Nova descrição do alerta
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o tipo do alerta.
     * @return Tipo do alerta
     */
    public String getAlertType() {
        return alertType;
    }

    /**
     * Define o tipo do alerta.
     * @param alertType Novo tipo do alerta
     */
    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }
}
