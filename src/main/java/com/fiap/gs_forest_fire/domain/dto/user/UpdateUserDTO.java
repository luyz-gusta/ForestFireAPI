package com.fiap.gs_forest_fire.domain.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {

    @NotNull
    private Long idUser;

    @NotNull
    private Boolean status;

    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Luiz Gustavo", requiredMode = Schema.RequiredMode.REQUIRED)
    private String fullName;

    @NotBlank(message = "Phone is required")
    @NotNull
    @Schema(example = "11940028922", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;

    @NotBlank(message = "State is required")
    @NotNull
    @Schema(example = "São Paulo", requiredMode = Schema.RequiredMode.REQUIRED)
    private String state;

    @NotBlank(message = "City is required")
    @NotNull
    @Schema(example = "Barueri", requiredMode = Schema.RequiredMode.REQUIRED)
    private String city;

    @NotBlank(message = "Department is required")
    @NotNull
    @Schema(example = "Hospital", requiredMode = Schema.RequiredMode.REQUIRED)
    private String department;

    @Nullable
    private String photo;
}
