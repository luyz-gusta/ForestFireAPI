package com.fiap.gs_forest_fire.domain.dto.login;

import com.fiap.gs_forest_fire.domain.entities.Team;
import com.fiap.gs_forest_fire.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseLoginDTO {
    private Long idLogin;
    private String email;

    private User user;
    private Team team;
}

