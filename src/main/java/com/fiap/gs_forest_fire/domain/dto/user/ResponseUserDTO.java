package com.fiap.gs_forest_fire.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseUserDTO {
    private Long idUser;
    private String fullName;
    private String phone;
    private String state;
    private String city;
    private String photo;
    private String department;
    private Boolean status;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
}

