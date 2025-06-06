package com.fiap.gs_forest_fire.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.gs_forest_fire.domain.dto.team.RequestTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade que representa as credenciais de acesso ao sistema.
 * Esta classe gerencia as informações de autenticação dos usuários e equipes,
 * incluindo email, senha e tipo de acesso (user/team).
 */
@Entity
@Table(name = "tb_login", schema = "db_gs_queimadas", catalog = "")
public class Login {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_login", nullable = false)
    private long idLogin;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Basic
    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_updated", nullable = true)
    private Timestamp dateUpdated;

    @OneToOne
    @JsonIgnore
    private User user;

    /**
     * Construtor padrão da classe Login.
     */
    public Login() {
    }

    /**
     * Construtor completo da classe Login.
     * @param idLogin ID do login
     * @param email Email do usuário
     * @param type Tipo de acesso (user/team)
     * @param password Senha do usuário
     * @param dateCreated Data de criação do registro
     * @param dateUpdated Data de atualização do registro
     */
    public Login(long idLogin, String email, String type, String password, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idLogin = idLogin;
        this.email = email;
        this.type = type;
        this.password = password;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Construtor que cria um login para usuário a partir de um DTO de requisição.
     * @param userDTO DTO contendo os dados do usuário
     */
    public Login(RequestUserDTO userDTO) {
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.type = "user";
    }

    /**
     * Construtor que cria um login para equipe a partir de um DTO de requisição.
     * @param teamDTO DTO contendo os dados da equipe
     */
    public Login(RequestTeamDTO teamDTO) {
        this.email = teamDTO.getEmail();
        this.password = teamDTO.getPassword();
        this.type = "team";
    }

    /**
     * Retorna o tipo de acesso do login.
     * @return Tipo de acesso (user/team)
     */
    public String getType() {
        return type;
    }

    /**
     * Define o tipo de acesso do login.
     * @param type Novo tipo de acesso
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retorna o ID do login.
     * @return ID único do login
     */
    public long getIdLogin() {
        return idLogin;
    }

    /**
     * Define o ID do login.
     * @param idLogin Novo ID do login
     */
    public void setIdLogin(long idLogin) {
        this.idLogin = idLogin;
    }

    /**
     * Retorna o email do usuário.
     * @return Email cadastrado
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     * @param email Novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a senha do usuário.
     * @return Senha criptografada
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     * @param password Nova senha
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna a data de criação do registro.
     * @return Data de criação do login
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
     * @return Data de atualização do login
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
