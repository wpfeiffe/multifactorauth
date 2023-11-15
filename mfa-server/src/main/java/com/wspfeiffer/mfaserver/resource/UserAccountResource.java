package com.wspfeiffer.mfaserver.resource;

import com.wspfeiffer.mfaserver.dto.UserAccountDto;
import com.wspfeiffer.mfaserver.services.impl.UserAccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserAccountResource {

    public final UserAccountServiceImpl userAccountService;

    @GetMapping
    public List<UserAccountDto> getUsers(@RequestParam(name = "username", required = false) Optional<String> username) throws OperationNotSupportedException {

        return username
                .map(s -> List.of(userAccountService.findByUsername(s)))
                .orElseGet(userAccountService::getUserAccounts);
    }

    @GetMapping("/{userId}")
    public UserAccountDto getUserById(@PathVariable("userId") Long userId){
        return userAccountService.getUserAccount(userId);
    }
}
