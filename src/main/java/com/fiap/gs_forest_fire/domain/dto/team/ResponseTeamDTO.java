package com.fiap.gs_forest_fire.domain.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTeamDTO {
    private Long idTeam;
    private String name;
    private String codName;
    private String locationName;
    private Timestamp lastAccess;
    private String quantityMembers;
    private String quantityVehicle;
    private String status;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
}

