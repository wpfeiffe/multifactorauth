package com.wspfeiffer.mfaserver.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.wspfeiffer.mfaserver.entities.UserRole}
 */
@Value
public class UserRoleDto implements Serializable {
    Long id;
    Short version;
    UserAccountDto user;
    RoleTypeDto role;
}
