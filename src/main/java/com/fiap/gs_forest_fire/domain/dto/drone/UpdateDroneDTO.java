package com.fiap.gs_forest_fire.domain.dto.drone;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDroneDTO {

    @NotNull
    private Long idDrone;

    @NotBlank(message = "Status is required")
    @NotNull
    @Schema(example = "Inativo", requiredMode = Schema.RequiredMode.REQUIRED)
    private String status;

    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Drone V8", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Codigo is required")
    @NotNull
    @Schema(example = "TS@955", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cod;

    @NotBlank(message = "battery quantity is required")
    @NotNull
    @Schema(example = "90%", requiredMode = Schema.RequiredMode.REQUIRED)
    private String battery;

    @NotBlank(message = "Location is required")
    @NotNull
    @Schema(example = "90%", requiredMode = Schema.RequiredMode.REQUIRED)
    private String location;
}