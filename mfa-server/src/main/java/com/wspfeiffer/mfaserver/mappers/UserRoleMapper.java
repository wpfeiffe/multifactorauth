package com.wspfeiffer.mfaserver.mappers;

import com.wspfeiffer.mfaserver.dto.UserRoleDto;
import com.wspfeiffer.mfaserver.entities.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    UserRoleMapper MAPPER = Mappers.getMapper( UserRoleMapper.class );

    UserRoleDto mapToDto(UserRole entity);
    UserRole mapToEntity(UserRoleDto dto);
    List<UserRoleDto> mapToListDto(List<UserRole> entity);
    List<UserRole> mapToListEntity(List<UserRoleDto> dto);
}
