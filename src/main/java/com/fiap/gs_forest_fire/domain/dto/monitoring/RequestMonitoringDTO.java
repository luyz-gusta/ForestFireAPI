package com.fiap.gs_forest_fire.domain.dto.monitoring;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestMonitoringDTO {
    @NotNull
    @Schema(example = "32.5", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double temperature;

    @NotNull
    @Schema(example = "98", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double humidity;

    @NotNull
    @Schema(example = "78", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double airQuality;

    @Schema(example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private long idDrone;

}