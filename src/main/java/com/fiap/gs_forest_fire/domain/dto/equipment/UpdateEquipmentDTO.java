package com.fiap.gs_forest_fire.domain.dto.equipment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEquipmentDTO {

    @NotNull
    private Long idEquipment;

    @NotNull
    private Boolean status;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Color is required")
    private String color;

    @NotNull(message = "Total quantity is required")
    private Integer totalQuantity;

    @NotNull(message = "Quantity used is required")
    private Integer quantityUsed;
}
