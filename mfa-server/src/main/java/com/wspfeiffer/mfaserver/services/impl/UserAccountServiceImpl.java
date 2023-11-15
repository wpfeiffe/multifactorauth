package com.wspfeiffer.mfaserver.services.impl;

import com.wspfeiffer.mfaserver.dto.UserAccountDto;
import com.wspfeiffer.mfaserver.dto.UserRoleDto;
import com.wspfeiffer.mfaserver.entities.UserAccount;
import com.wspfeiffer.mfaserver.entities.UserRole;
import com.wspfeiffer.mfaserver.mappers.UserAccountMapper;
import com.wspfeiffer.mfaserver.mappers.UserRoleMapper;
import com.wspfeiffer.mfaserver.repositories.UserAccountRepository;
import com.wspfeiffer.mfaserver.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl {

    private final UserAccountRepository userAccountRepository;
    private final UserRoleRepository userRoleRepository;

    public List<UserAccountDto> getUserAccounts() {
        return UserAccountMapper.MAPPER.mapToListDto(userAccountRepository.findAll());
    }

    public UserAccountDto getUserAccount(Long id) {
        return userAccountRepository.findById(id).map(UserAccountMapper.MAPPER::mapToDto)
                .orElseThrow(() -> new RuntimeException("UserAccount not found"));
    }

    public UserAccountDto findByUsername(String username) {
        return userAccountRepository.findByUsername(username).map(UserAccountMapper.MAPPER::mapToDto)
                .orElseThrow(() -> new RuntimeException("UserAccount not found"));
    }

    @Transactional
    public UserAccountDto createUserAccount(UserAccountDto userAccount) {
        var userAccountEntity = UserAccountMapper.MAPPER.mapToEntity(userAccount);
        userAccountEntity.setPassword(UserAccount.DEFAULT_PASSWORD);
        return UserAccountMapper.MAPPER.mapToDto(
                userAccountRepository.save(userAccountEntity));
    }

    @Transactional
    public UserAccountDto updateUserAccount(Long id, UserAccountDto updatedUserAccount) {
        UserAccount existingUserAccount = userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAccount not found"));
        existingUserAccount.setActive(updatedUserAccount.getActive());
        existingUserAccount.setEmail(updatedUserAccount.getEmail());
        existingUserAccount.setFirstName(updatedUserAccount.getFirstName());
        existingUserAccount.setLastName(updatedUserAccount.getLastName());
        existingUserAccount.setTotpCode(updatedUserAccount.getTotpCode());
        existingUserAccount.setUsername(updatedUserAccount.getUsername());
        return UserAccountMapper.MAPPER.mapToDto(userAccountRepository.save(existingUserAccount));
    }

    @Transactional
    public void deleteUserAccount(Long id) {
        userAccountRepository.deleteById(id);
    }

    public List<UserRoleDto> getUserRoles(Long id) {
        List<UserRole> roles = userRoleRepository.findByUserId(id);
        return UserRoleMapper.MAPPER.mapToListDto(roles);
    }

}
