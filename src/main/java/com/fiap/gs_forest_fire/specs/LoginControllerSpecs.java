package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.login.RequestLoginDTO;
import com.fiap.gs_forest_fire.domain.dto.login.ResponseLoginDTO;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.specs.error.ApiResponseBadRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Login", description = "Login operation")
public interface LoginControllerSpecs {
    @Operation(summary = "Login")
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<ResponseLoginDTO>> login(@RequestBody RequestLoginDTO dataLogin);
}
