package com.fiap.gs_forest_fire.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.UpdateUserDTO;
import jakarta.persistence.*;
import lombok.extern.java.Log;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

    public User() {
    }

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

    public User(RequestUserDTO userDTO, Login login){
        this.login = login;
        this.fullName = userDTO.getFullName();
        this.photo = userDTO.getPhoto();
        this.phone = userDTO.getPhone();
        this.city = userDTO.getCity();
        this.state = userDTO.getState();
        this.department = userDTO.getDepartment();
    }

    public void setUpdatedUser(UpdateUserDTO userDTO) {
        this.fullName = userDTO.getFullName();
        this.photo = userDTO.getPhoto();
        this.phone = userDTO.getPhone();
        this.city = userDTO.getCity();
        this.state = userDTO.getState();
        this.department = userDTO.getDepartment();
        this.status = userDTO.getStatus();
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public Login getLogin() {
        return login;
    }

    public void setIdLogin(Login login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
