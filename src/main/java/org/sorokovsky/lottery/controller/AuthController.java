package org.sorokovsky.lottery.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.contract.LoginUser;
import org.sorokovsky.lottery.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PatchMapping("refresh-tokens")
    public ResponseEntity<?> refreshTokens(HttpServletRequest request, HttpServletResponse response) {
        var success = authService.refreshTokens(request, response);
        if (success) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Refresh tokens failed");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUser user, HttpServletRequest request, HttpServletResponse response) {
        var responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("Email or password is incorrect");
        var success = authService.login(user, request, response);
        if (success) return ResponseEntity.noContent().build();
        return responseEntity;
    }
}
