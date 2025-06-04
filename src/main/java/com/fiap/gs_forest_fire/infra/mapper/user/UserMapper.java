package com.fiap.gs_forest_fire.infra.mapper.user;

import com.fiap.gs_forest_fire.domain.dto.user.ResponseUserDTO;
import com.fiap.gs_forest_fire.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ResponseUserDTO toUserResponse(User entity);
}
