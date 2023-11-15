package com.wspfeiffer.mfaserver.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.wspfeiffer.mfaserver.entities.RoleType}
 */
@Value
public class RoleTypeDto implements Serializable {
    String role;
    String description;
}
