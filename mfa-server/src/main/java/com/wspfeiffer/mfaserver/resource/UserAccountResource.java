package com.wspfeiffer.mfaserver.resource;

import com.wspfeiffer.mfaserver.dto.UserAccountDto;
import com.wspfeiffer.mfaserver.services.impl.NationParksService;
import com.wspfeiffer.mfaserver.services.impl.UserAccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
@Secured("ROLE_USER")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserAccountResource {

    public final UserAccountServiceImpl userAccountService;
    public final NationParksService nationParksService;

    @GetMapping
    @Secured("ROLE_USER")
    public List<UserAccountDto> getUsers(@RequestParam(name = "username", required = false) Optional<String> username, Authentication authentication) throws OperationNotSupportedException {

        return username
                .map(s -> List.of(userAccountService.findByUsername(s)))
                .orElseGet(userAccountService::getUserAccounts);
    }

    @GetMapping("/{userId}")
    public UserAccountDto getUserById(@PathVariable("userId") Long userId){
        return userAccountService.getUserAccount(userId);
    }
}
