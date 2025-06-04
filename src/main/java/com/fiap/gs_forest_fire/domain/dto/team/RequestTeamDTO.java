package com.fiap.gs_forest_fire.domain.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestTeamDTO {

    @NotNull
    private Boolean status;

    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Time de bombeiros", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "CodName is required")
    @NotNull
    @Schema(example = "Bomb-001", requiredMode = Schema.RequiredMode.REQUIRED)
    private String codName;

    @NotBlank(message = "LocationName is required")
    @NotNull
    @Schema(example = "São Paulo", requiredMode = Schema.RequiredMode.REQUIRED)
    private String locationName;

    @NotBlank(message = "City is required")
    @NotNull
    @Schema(example = "2025-10-10", requiredMode = Schema.RequiredMode.REQUIRED)
    private Timestamp lastAccess;

    @NotBlank(message = "email is required")
    @NotNull
    @Email(message = "must be a well-formed email address")
    @Schema(example = "gustavo@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "Quantity Members is required")
    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int quantityMembers;

    @NotBlank(message = "Quantity Vehicle is required")
    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int quantityVehicle;

    @NotBlank(message = "password is required")
    @NotNull
    private String password;
}
