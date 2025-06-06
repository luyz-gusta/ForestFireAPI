package com.fiap.gs_forest_fire.domain.dto.severity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSeverityDTO {
    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Critico", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Color is required")
    @NotNull
    @Schema(example = "#FF00FF", requiredMode = Schema.RequiredMode.REQUIRED)
    private String color;

    @Schema(example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    private boolean status;
}
