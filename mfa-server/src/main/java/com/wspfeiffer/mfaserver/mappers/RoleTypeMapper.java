package com.wspfeiffer.mfaserver.mappers;

import com.wspfeiffer.mfaserver.dto.RoleTypeDto;
import com.wspfeiffer.mfaserver.entities.RoleType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleTypeMapper {
    RoleTypeMapper MAPPER = Mappers.getMapper( RoleTypeMapper.class );
    
    RoleTypeDto mapToDto(RoleType entity);
    RoleType mapToEntity(RoleTypeDto dto);
    List<RoleTypeDto> mapToListDto(List<RoleType> entity);
    List<RoleType> mapToListEntity(List<RoleTypeDto> dto);
}
