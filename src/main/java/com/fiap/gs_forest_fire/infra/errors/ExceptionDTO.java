package com.fiap.gs_forest_fire.infra.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ExceptionDTO {
    private Integer status;
    private String message;
}
