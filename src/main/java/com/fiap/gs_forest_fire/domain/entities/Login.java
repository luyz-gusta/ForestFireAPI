package com.fiap.gs_forest_fire.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.gs_forest_fire.domain.dto.team.RequestTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "email", nullable = false, length = 255)
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

    public Login() {
    }

    public Login(long idLogin, String email, String type, String password, Timestamp dateCreated, Timestamp dateUpdated) {
        this.idLogin = idLogin;
        this.email = email;
        this.type = type;
        this.password = password;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Login(RequestUserDTO userDTO) {
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.type = "user";
    }

    public Login(RequestTeamDTO teamDTO) {
        this.email = teamDTO.getEmail();
        this.password = teamDTO.getPassword();
        this.type = "team";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(long idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
