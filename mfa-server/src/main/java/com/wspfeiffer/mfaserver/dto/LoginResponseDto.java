package com.wspfeiffer.mfaserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private Boolean mfaEnabled;
    private Boolean loginSuccess;
    private String message;
    private String mfaToken;
    private UserAccountDto userAccount;

}
