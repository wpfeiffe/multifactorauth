package com.wspfeiffer.mfaserver.security;

import com.wspfeiffer.mfaserver.dto.UserAccountDto;
import com.wspfeiffer.mfaserver.dto.UserRoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MfaUserDetails implements UserDetails {

    final UserAccountDto userAccount;
    final List<UserRoleDto> userRoles;

    public MfaUserDetails(UserAccountDto userAccount, List<UserRoleDto> userRoles) {
        this.userAccount = userAccount;
        this.userRoles = userRoles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoles.stream()
                .map(ur -> new SimpleGrantedAuthority(ur.getRole().getRole()))
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userAccount.getActive();
    }
}
