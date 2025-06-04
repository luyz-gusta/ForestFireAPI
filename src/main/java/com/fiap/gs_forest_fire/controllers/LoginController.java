package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.domain.dto.login.RequestLoginDTO;
import com.fiap.gs_forest_fire.domain.dto.login.ResponseLoginDTO;
import com.fiap.gs_forest_fire.domain.dto.user.ResponseUserDTO;
import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.service.LoginService;
import com.fiap.gs_forest_fire.service.UserService;
import com.fiap.gs_forest_fire.specs.LoginControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController implements LoginControllerSpecs {
    private final LoginService service;

    @PostMapping
    public ResponseEntity<ApiSingleResponse<ResponseLoginDTO>> login(@RequestBody @Valid RequestLoginDTO dataLogin){

        try {
            ResponseLoginDTO login = service.login(dataLogin.getEmail(), dataLogin.getPassword());

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(login));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
