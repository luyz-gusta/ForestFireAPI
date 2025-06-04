package com.fiap.gs_forest_fire.domain.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDTO {

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

    @NotBlank(message = "email is required")
    @NotNull
    @Email(message = "must be a well-formed email address")
    @Schema(example = "gustavo@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "Department is required")
    @NotNull
    @Schema(example = "Hospital", requiredMode = Schema.RequiredMode.REQUIRED)
    private String department;

    @NotBlank(message = "password is required")
    @NotNull
    private String password;

    @Nullable
    private String photo;
}
