package com.fiap.gs_forest_fire.domain.dto.operation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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

    @NotNull
    @Schema(example = "2025-05-25", requiredMode = Schema.RequiredMode.REQUIRED)
    private Timestamp startTime;

    @NotNull
    @Schema(example = "2025-05-25", requiredMode = Schema.RequiredMode.REQUIRED)
    private Timestamp endTime;

    @NotNull
    @Schema(example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private int quantityTeams;

    @NotNull
    @Schema(example = "500 ectares", requiredMode = Schema.RequiredMode.REQUIRED)
    private String affectedArea;

    @Nullable
    @Schema(example = "500 ectares", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer evacuees;

    @Nullable
    @Schema(example = "True", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Boolean status;

    @Schema(example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private long idSeverity;

}