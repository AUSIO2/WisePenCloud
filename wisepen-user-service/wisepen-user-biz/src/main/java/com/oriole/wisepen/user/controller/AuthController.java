package com.oriole.wisepen.user.controller;

import com.oriole.wisepen.common.core.domain.R;
import com.oriole.wisepen.user.api.domain.dto.LoginBody;
import com.oriole.wisepen.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public R<String> login(@RequestBody LoginBody loginBody) {
        return authService.login(loginBody);
    }

    @PostMapping("/logout")
    public R<Void> logout() {
        return authService.logout();
    }
}