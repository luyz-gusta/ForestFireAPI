package com.fiap.gs_forest_fire.domain.dto.equipment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEquipmentDTO {
    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Caminhão pipa", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Color is required")
    @NotNull
    @Schema(example = "#FF00FF", requiredMode = Schema.RequiredMode.REQUIRED)
    private String color;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int totalQuantity;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int quantityUsed;
}
