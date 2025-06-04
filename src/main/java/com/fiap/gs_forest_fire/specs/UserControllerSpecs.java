package com.fiap.gs_forest_fire.specs;

import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.ResponseUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.UpdateUserDTO;
import com.fiap.gs_forest_fire.infra.responses.details.ApiListResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiMessageResponse;
import com.fiap.gs_forest_fire.infra.responses.details.ApiSingleResponse;
import com.fiap.gs_forest_fire.specs.error.ApiResponseBadRequest;
import com.fiap.gs_forest_fire.specs.error.ApiResponseDuplicatedResource;
import com.fiap.gs_forest_fire.specs.error.ApiResponseNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Tag(name = "User", description = "User operations")
public interface UserControllerSpecs {

    @Operation(summary = "Find all users")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<ResponseUserDTO>> getAllUsers();

    @Operation(summary = "Find user by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> getUserById(@PathVariable Long id);

    @Operation(summary = "Find user by status when active status")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<ResponseUserDTO>> getAllUsersByActive();


    @Operation(summary = "Create user")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> registerUser(@RequestBody RequestUserDTO userDTO);

    @Operation(summary = "Updade user")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> updateUser(@RequestBody @Valid UpdateUserDTO userDTO);

    @Operation(summary = "Toogle status user")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> toogleStatus(@PathVariable Long id);

    @Operation(summary = "Delete user")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteUser(@PathVariable Long id);


}
