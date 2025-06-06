package com.fiap.gs_forest_fire.domain.entities;

import com.fiap.gs_forest_fire.domain.dto.equipment.RequestEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.equipment.UpdateEquipmentDTO;
import com.fiap.gs_forest_fire.domain.dto.team.UpdateTeamDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Entidade que representa um equipamento no sistema.
 * Esta classe gerencia informações sobre os equipamentos utilizados no combate a incêndios,
 * incluindo quantidade total, quantidade em uso, status e identificação visual.
 */
@Entity
@Table(name = "tb_equipment", schema = "db_gs_queimadas", catalog = "")
public class Equipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_equipment", nullable = false)
    private long idEquipment;
    @Basic
    @Column(name = "name", nullable = false, length = 120)
    private String name;
    @Basic
    @Column(name = "color", nullable = false, length = 50)
    private String color;
    @Basic
    @Column(name = "total_quantity", nullable = false)
    private int totalQuantity;
    @Basic
    @Column(name = "quantity_used", nullable = false)
    private int quantityUsed;
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
     * Construtor padrão da classe Equipment.
     */
    public Equipment() {
    }

    /**
     * Construtor completo da classe Equipment.
     * @param idEquipment ID do equipamento
     * @param name Nome do equipamento
     * @param color Cor de identificação
     * @param totalQuantity Quantidade total disponível
     * @param quantityUsed Quantidade em uso
     * @param status Status de disponibilidade
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
    public Equipment(long idEquipment, String name, String color, int totalQuantity, int quantityUsed, Boolean status, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idEquipment = idEquipment;
        this.name = name;
        this.color = color;
        this.totalQuantity = totalQuantity;
        this.quantityUsed = quantityUsed;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Construtor que cria um equipamento a partir de um DTO de requisição.
     * @param equipmentDTO DTO contendo os dados do equipamento
     */
    public Equipment(RequestEquipmentDTO equipmentDTO) {
        this.name = equipmentDTO.getName();
        this.color = equipmentDTO.getColor();
        this.totalQuantity = equipmentDTO.getTotalQuantity();
        this.quantityUsed = equipmentDTO.getQuantityUsed();
    }

    /**
     * Atualiza os dados do equipamento com base em um DTO de atualização.
     * @param equipmentDTO DTO contendo os novos dados do equipamento
     */
    public void setUpdatedEquipment(UpdateEquipmentDTO equipmentDTO) {
        this.name = equipmentDTO.getName();
        this.color = equipmentDTO.getColor();
        this.totalQuantity = equipmentDTO.getTotalQuantity();
        this.quantityUsed = equipmentDTO.getQuantityUsed();
        this.status = equipmentDTO.getStatus();
    }

    /**
     * Retorna o ID do equipamento.
     * @return ID único do equipamento
     */
    public long getIdEquipment() {
        return idEquipment;
    }

    /**
     * Define o ID do equipamento.
     * @param idEquipment Novo ID do equipamento
     */
    public void setIdEquipment(long idEquipment) {
        this.idEquipment = idEquipment;
    }

    /**
     * Retorna o nome do equipamento.
     * @return Nome do equipamento
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do equipamento.
     * @param name Novo nome do equipamento
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a cor de identificação do equipamento.
     * @return Cor do equipamento
     */
    public String getColor() {
        return color;
    }

    /**
     * Define a cor de identificação do equipamento.
     * @param color Nova cor do equipamento
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retorna a quantidade total de unidades do equipamento.
     * @return Quantidade total disponível
     */
    public int getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * Define a quantidade total de unidades do equipamento.
     * @param totalQuantity Nova quantidade total
     */
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    /**
     * Retorna a quantidade de unidades em uso do equipamento.
     * @return Quantidade em uso
     */
    public int getQuantityUsed() {
        return quantityUsed;
    }

    /**
     * Define a quantidade de unidades em uso do equipamento.
     * @param quantityUsed Nova quantidade em uso
     */
    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    /**
     * Retorna o status de disponibilidade do equipamento.
     * @return Status atual (disponível/indisponível)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Define o status de disponibilidade do equipamento.
     * @param status Novo status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação do equipamento
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
     * @return Data de atualização do equipamento
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
