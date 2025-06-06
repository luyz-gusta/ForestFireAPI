package com.fiap.gs_forest_fire.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.UpdateUserDTO;
import jakarta.persistence.*;
import lombok.extern.java.Log;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade que representa um usuário do sistema.
 * Esta classe gerencia informações sobre os usuários que operam o sistema,
 * incluindo dados pessoais, localização, departamento e status.
 */
@Entity
@Table(name = "tb_user", schema = "db_gs_queimadas", catalog = "")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user", nullable = false)
    private long idUser;
    @Basic
    @Column(name = "full_name", nullable = false, length = 120)
    private String fullName;
    @Basic
    @Column(name = "photo", nullable = true, length = 255)
    private String photo;
    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @Basic
    @Column(name = "city", nullable = false, length = 100)
    private String city;
    @Basic
    @Column(name = "state", nullable = false, length = 100)
    private String state;
    @Basic
    @Column(name = "status", nullable = true)
    private Boolean status;
    @Basic
    @Column(name = "department", nullable = false)
    private String department;
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
     * Construtor padrão da classe User.
     */
    public User() {
    }

    /**
     * Construtor completo da classe User.
     * @param idUser ID do usuário
     * @param login Credenciais de acesso do usuário
     * @param fullName Nome completo do usuário
     * @param photo URL da foto do usuário
     * @param phone Número de telefone
     * @param city Cidade do usuário
     * @param state Estado do usuário
     * @param status Status de ativação do usuário
     * @param department Departamento do usuário
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
    public User(long idUser, Login login, String fullName, String photo, String phone, String city, String state, Boolean status, String department, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idUser = idUser;
        this.login = login;
        this.fullName = fullName;
        this.photo = photo;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.status = status;
        this.department = department;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Construtor que cria um usuário a partir de um DTO de requisição.
     * @param userDTO DTO contendo os dados do usuário
     * @param login Credenciais de acesso do usuário
     */
    public User(RequestUserDTO userDTO, Login login){
        this.login = login;
        this.fullName = userDTO.getFullName();
        this.photo = userDTO.getPhoto();
        this.phone = userDTO.getPhone();
        this.city = userDTO.getCity();
        this.state = userDTO.getState();
        this.department = userDTO.getDepartment();
    }

    /**
     * Atualiza os dados do usuário com base em um DTO de atualização.
     * @param userDTO DTO contendo os novos dados do usuário
     */
    public void setUpdatedUser(UpdateUserDTO userDTO) {
        this.fullName = userDTO.getFullName();
        this.photo = userDTO.getPhoto();
        this.phone = userDTO.getPhone();
        this.city = userDTO.getCity();
        this.state = userDTO.getState();
        this.department = userDTO.getDepartment();
        this.status = userDTO.getStatus();
    }

    /**
     * Retorna o ID do usuário.
     * @return ID único do usuário
     */
    public long getIdUser() {
        return idUser;
    }

    /**
     * Define o ID do usuário.
     * @param idUser Novo ID do usuário
     */
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    /**
     * Retorna as credenciais de acesso do usuário.
     * @return Objeto Login associado
     */
    public Login getLogin() {
        return login;
    }

    /**
     * Define as credenciais de acesso do usuário.
     * @param login Novas credenciais de acesso
     */
    public void setIdLogin(Login login) {
        this.login = login;
    }

    /**
     * Retorna o nome completo do usuário.
     * @return Nome completo
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Define o nome completo do usuário.
     * @param fullName Novo nome completo
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retorna a URL da foto do usuário.
     * @return URL da foto
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Define a URL da foto do usuário.
     * @param photo Nova URL da foto
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Retorna o número de telefone do usuário.
     * @return Número de telefone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Define o número de telefone do usuário.
     * @param phone Novo número de telefone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retorna a cidade do usuário.
     * @return Nome da cidade
     */
    public String getCity() {
        return city;
    }

    /**
     * Define a cidade do usuário.
     * @param city Nova cidade
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retorna o estado do usuário.
     * @return Nome do estado
     */
    public String getState() {
        return state;
    }

    /**
     * Define o estado do usuário.
     * @param state Novo estado
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retorna o status de ativação do usuário.
     * @return Status atual (ativo/inativo)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Define o status de ativação do usuário.
     * @param status Novo status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Retorna o departamento do usuário.
     * @return Nome do departamento
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Define o departamento do usuário.
     * @param department Novo departamento
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação do usuário
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
     * @return Data de atualização do usuário
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
