package com.wspfeiffer.mfaserver.mappers;

import com.wspfeiffer.mfaserver.dto.UserAccountDto;
import com.wspfeiffer.mfaserver.entities.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserAccountMapper {
    UserAccountMapper MAPPER = Mappers.getMapper( UserAccountMapper.class );

    UserAccountDto mapToDto(UserAccount entity);
    UserAccount mapToEntity(UserAccountDto dto);
    List<UserAccountDto> mapToListDto(List<UserAccount> entity);
    List<UserAccount> mapToListEntity(List<UserAccountDto> dto);
}
