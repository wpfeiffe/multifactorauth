package com.wspfeiffer.mfaserver.resource;

import com.wspfeiffer.mfaserver.dto.LoginDto;
import com.wspfeiffer.mfaserver.dto.LoginResponseDto;
import com.wspfeiffer.mfaserver.dto.MfaRequestDto;
import com.wspfeiffer.mfaserver.security.MfaUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthResource {
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
            .getContextHolderStrategy();

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping    ("/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        Authentication currAuth = SecurityContextHolder.getContext().getAuthentication();
        if (currAuth.isAuthenticated()) {
            LoginResponseDto loginResponseDto =  new LoginResponseDto(false, true, "OK", "", ((MfaUserDetails) currAuth.getPrincipal()).getUserAccount());
            return ResponseEntity.ok(loginResponseDto);
        }
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            MfaUserDetails userDetails;
            if (authentication.getPrincipal() instanceof MfaUserDetails) {
                userDetails = (MfaUserDetails) authentication.getPrincipal();
            } else {
                LoginResponseDto loginResponse = new LoginResponseDto(false, false, "Bad Credentials", "", null);
                return ResponseEntity.badRequest().body(loginResponse);
            }

            if (userDetails.getUserAccount().getMfaEnabled()) {
                UUID uuid = UUID.nameUUIDFromBytes(userDetails.getUserAccount().getUsername().getBytes());
                request.getSession().setAttribute(uuid.toString(), authentication);
                LoginResponseDto loginResponse = new LoginResponseDto(true, false, "MFA Enabled", uuid.toString(), null);
                return ResponseEntity.ok(loginResponse);
            } else {
                SecurityContext context = this.securityContextHolderStrategy.createEmptyContext();
                context.setAuthentication(authentication);
                this.securityContextHolderStrategy.setContext(context);
                LoginResponseDto loginResponseDto =  new LoginResponseDto(false, true, "OK", "", userDetails.getUserAccount());
                return ResponseEntity.ok(loginResponseDto);
            }
        } catch (AuthenticationException e) {
            LoginResponseDto loginResponse = new LoginResponseDto(false, false, "Bad Credentials", "", null);
            return ResponseEntity.badRequest().body(loginResponse);
        }
    }


    @PostMapping    ("/verify")
    ResponseEntity<LoginResponseDto> login(@RequestBody MfaRequestDto mfaRequest, HttpServletRequest request) {
        Authentication authentication = (Authentication) request.getSession().getAttribute(mfaRequest.getMfaToken());
        if (authentication != null) {
            var mfaUserDetails = (MfaUserDetails) authentication.getPrincipal();
            LoginResponseDto loginResponse = new LoginResponseDto(true, true, "OK", "", mfaUserDetails.getUserAccount());
            var newContext = SecurityContextHolder.createEmptyContext();

            newContext.setAuthentication(authentication);
            SecurityContextHolder.setContext(newContext);
            return ResponseEntity.ok(loginResponse);
        } else {
            LoginResponseDto loginResponse = new LoginResponseDto(true, false, "Bad Credentials", "", null);
            return ResponseEntity.badRequest().body(loginResponse);
        }
    }
}
