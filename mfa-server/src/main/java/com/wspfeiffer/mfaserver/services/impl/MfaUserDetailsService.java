package com.wspfeiffer.mfaserver.services.impl;

import com.wspfeiffer.mfaserver.dto.UserAccountDto;
import com.wspfeiffer.mfaserver.dto.UserRoleDto;
import com.wspfeiffer.mfaserver.security.MfaUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
@RequiredArgsConstructor
public class MfaUserDetailsService implements UserDetailsService
{

    final UserAccountServiceImpl userAccountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountDto userAccount = userAccountService.findByUsername(username);
        List<UserRoleDto> userRoles = userAccountService.getUserRoles(userAccount.getId());
        return new MfaUserDetails(userAccount, userRoles);
    }
}
