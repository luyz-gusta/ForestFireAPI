package com.fiap.gs_forest_fire.domain.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoginDTO {
    @NotBlank(message = "email is required")
    @NotNull
    @Email(message = "must be a well-formed email address")
    @Schema(example = "gustavo@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "password is required")
    @NotNull
    private String password;
}
