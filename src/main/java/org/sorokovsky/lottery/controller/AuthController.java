package org.sorokovsky.lottery.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.anotation.CurrentUser;
import org.sorokovsky.lottery.contract.ApiError;
import org.sorokovsky.lottery.contract.LoginUser;
import org.sorokovsky.lottery.contract.RegisterUser;
import org.sorokovsky.lottery.entity.UserEntity;
import org.sorokovsky.lottery.service.AuthService;
import org.sorokovsky.lottery.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsersService usersService;

    @PatchMapping("/refresh-tokens")
    public ResponseEntity<?> refreshTokens(HttpServletRequest request, HttpServletResponse response) {
        var success = authService.refreshTokens(request, response);
        if (success) return ResponseEntity.noContent().build();
        var apiError = new ApiError("Refresh tokens failed", HttpStatus.FORBIDDEN.value());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUser user, HttpServletRequest request, HttpServletResponse response) {
        var created = authService.register(user, request, response);
        var apiError = new ApiError("User already exists", HttpStatus.BAD_REQUEST.value());
        if (created.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        var createdUser = created.get();
        return ResponseEntity
                .created(URI.create("/auth/users/"))
                .body(usersService.toGetUser(createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUser user, HttpServletRequest request, HttpServletResponse response) {
        var apiError = new ApiError("Email or password is incorrect", HttpStatus.BAD_REQUEST.value());
        var responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiError);
        var success = authService.login(user, request, response);
        if (success) return ResponseEntity.noContent().build();
        return responseEntity;
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@CurrentUser UserEntity user) {
        return ResponseEntity.ok(usersService.toGetUser(user));
    }
}
