package org.sorokovsky.lottery.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.anotation.CurrentUser;
import org.sorokovsky.lottery.contract.LoginUser;
import org.sorokovsky.lottery.contract.RegisterUser;
import org.sorokovsky.lottery.entity.UserEntity;
import org.sorokovsky.lottery.service.AuthService;
import org.sorokovsky.lottery.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsersService usersService;

    @PatchMapping("/refresh-tokens")
    public ResponseEntity<?> refreshTokens(HttpServletRequest request, HttpServletResponse response) {
        authService.refreshTokens(request, response);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUser user, HttpServletRequest request, HttpServletResponse response) {
        var created = authService.register(user, request, response);
        return ResponseEntity
                .ok()
                .body(usersService.toGetUser(created));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUser user, HttpServletRequest request, HttpServletResponse response) {
        authService.login(user, request, response);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@CurrentUser UserEntity user) {
        return ResponseEntity.ok(usersService.toGetUser(user));
    }
}
