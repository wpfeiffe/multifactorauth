package com.wspfeiffer.mfaserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.wspfeiffer.mfaserver.entities.UserAccount}
 */
@Value
public class UserAccountDto implements Serializable {
    Long id;
    Short version;
    String username;
    String email;
    @JsonIgnore
    String password;
    String firstName;
    String lastName;
    Boolean active;
    Boolean mfaEnabled;
    @JsonIgnore
    String totpCode;
}
