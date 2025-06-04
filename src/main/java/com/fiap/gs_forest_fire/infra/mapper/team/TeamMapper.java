package com.fiap.gs_forest_fire.infra.mapper.team;

import com.fiap.gs_forest_fire.domain.dto.team.ResponseTeamDTO;
import com.fiap.gs_forest_fire.domain.dto.user.ResponseUserDTO;
import com.fiap.gs_forest_fire.domain.entities.Team;
import com.fiap.gs_forest_fire.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    ResponseTeamDTO toTeamResponse(Team entity);
}
