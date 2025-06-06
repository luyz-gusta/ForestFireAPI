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
public class RequestOperationDTO {
    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Operacao floresta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Codigo is required")
    @NotNull
    @Schema(example = "OP536", requiredMode = Schema.RequiredMode.REQUIRED)
    private String codName;

    @NotBlank(message = "Description is required")
    @NotNull
    @Schema(example = "Descricao", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
}