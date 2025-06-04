package com.fiap.gs_forest_fire.controllers;

import com.fiap.gs_forest_fire.infra.responses.ApiResponseBuilder;
import com.fiap.gs_forest_fire.service.UserService;
import com.fiap.gs_forest_fire.specs.UserControllerSpecs;
import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.ResponseUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.UpdateUserDTO;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController implements UserControllerSpecs {
    private final UserService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<ResponseUserDTO>> getAllUsers() {
        try {
            List<ResponseUserDTO> users = service.listAllUsers();

            System.out.println(users);

            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(users));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }


    @GetMapping("/active")
    public ResponseEntity<ApiListResponse<ResponseUserDTO>> getAllUsersByActive() {
        try {
            List<ResponseUserDTO> users = service.listUsersActive();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(users));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> getUserById(@PathVariable Long id) {
        try {
            ResponseUserDTO user = service.listUserById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(user));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> registerUser(
            @RequestBody @Valid RequestUserDTO userDTO
    ) {
        try {
            ResponseUserDTO user = service.saveUser(userDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(user));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> updateUser(@RequestBody @Valid UpdateUserDTO userDTO) {
        try {
            ResponseUserDTO user = service.editUser(userDTO);

            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(user));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping("/toogle-status/{id}")
    @Transactional
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> toogleStatus(@PathVariable Long id) {
        try {
            ResponseUserDTO user = service.editUserStatus(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(user));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteUser(@PathVariable Long id) {
        try {
            service.excludeUser(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}