package com.fiap.gs_forest_fire.domain.dto.operation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOperationDTO {
    @NotNull
    private Long idAlert;

    @NotBlank(message = "Description is required")
    @NotNull
    @Schema(example = "Alerta Teste", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @NotBlank(message = "AlertType is required")
    @NotNull
    @Schema(example = "Critico", requiredMode = Schema.RequiredMode.REQUIRED)
    private String alertType;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long idSeverity;
}