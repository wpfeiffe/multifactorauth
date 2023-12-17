package com.wspfeiffer.mfaserver.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.log.LogMessage;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class MfaAuthFilter extends OncePerRequestFilter {

    private final AuthenticationConverter basicAuthenticationConverter = new BasicAuthenticationConverter();
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
            .getContextHolderStrategy();
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Before MfaAuthFilter");
        filterChain.doFilter(request, response);
        log.info("After MfaAuthFilter");

//        Authentication authRequest = this.basicAuthenticationConverter.convert(request);
//        if (authRequest == null) {
//            filterChain.doFilter(request, response);
//            log.info("After MfaAuthFilter");
//            return;
//        }
//
//        String username = authRequest.getName();
//        this.logger.trace(LogMessage.format("Found username '%s' in Basic Authorization header", username));
//        filterChain.doFilter(request, response);
//        log.info("After MfaAuthFilter");
//        return;
    }

    protected boolean authenticationIsRequired(String username) {
        // Only reauthenticate if username doesn't match SecurityContextHolder and user
        // isn't authenticated (see SEC-53)
        Authentication existingAuth = this.securityContextHolderStrategy.getContext().getAuthentication();
        if (existingAuth == null || !existingAuth.getName().equals(username) || !existingAuth.isAuthenticated()) {
            return true;
        }
        // Handle unusual condition where an AnonymousAuthenticationToken is already
        // present. This shouldn't happen very often, as BasicAuthenticationFilter is
        // meant to
        // be earlier in the filter chain than AnonymousAuthenticationFilter.
        // Nevertheless, presence of both an AnonymousAuthenticationToken together with a
        // BASIC authentication request header should indicate reauthentication using the
        // BASIC protocol is desirable. This behaviour is also consistent with that
        // provided by form and digest, both of which force re-authentication if the
        // respective header is detected (and in doing so replace/ any existing
        // AnonymousAuthenticationToken). See SEC-610.
        return (existingAuth instanceof AnonymousAuthenticationToken);
    }
}
