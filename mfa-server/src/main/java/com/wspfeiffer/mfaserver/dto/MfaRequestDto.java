package com.wspfeiffer.mfaserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MfaRequestDto {
    private String mfaCode;
    private String mfaToken;
}
