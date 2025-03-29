package org.sorokovsky.lottery.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.contract.LoginUser;
import org.sorokovsky.lottery.contract.RegisterUser;
import org.sorokovsky.lottery.entity.UserEntity;
import org.sorokovsky.lottery.exception.BadRequestException;
import org.sorokovsky.lottery.exception.ForbiddenException;
import org.sorokovsky.lottery.factory.DefaultAccessTokenFactory;
import org.sorokovsky.lottery.factory.RefreshTokenRecreateFactory;
import org.sorokovsky.lottery.repository.DefaultAccessTokenRepository;
import org.sorokovsky.lottery.repository.DefaultRefreshTokenRepository;
import org.sorokovsky.lottery.strategy.JwtSessionStrategy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final DefaultAccessTokenRepository accessTokenRepository;
    private final DefaultRefreshTokenRepository refreshTokenRepository;
    private final DefaultAccessTokenFactory accessTokenFactory;
    private final RefreshTokenRecreateFactory refreshTokenRecreateFactory;
    private final JwtSessionStrategy jwtSessionStrategy;
    private final AuthenticationManager manager;
    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    public void refreshTokens(HttpServletRequest request, HttpServletResponse response) {
        var refreshToken = refreshTokenRepository.get(request);
        if (refreshToken == null)
            throw new ForbiddenException("Refresh token not found");
        var accessToken = accessTokenFactory.apply(refreshToken);
        accessTokenRepository.set(accessToken, response);
        var newRefreshToken = refreshTokenRecreateFactory.apply(refreshToken);
        refreshTokenRepository.set(newRefreshToken, response);
    }

    public UserEntity register(RegisterUser user, HttpServletRequest request, HttpServletResponse response) {
        var existingUser = usersService.existsByEmail(user.email());
        if (existingUser) throw new BadRequestException("User already exists");
        var userEntity = UserEntity.builder().email(user.email()).password(user.password()).build();
        var createdUser = usersService.create(userEntity);
        authenticate(new LoginUser(user.email(), user.password()), request, response);
        return createdUser;

    }

    public void login(LoginUser user, HttpServletRequest request, HttpServletResponse response) {
        var exception = new BadRequestException("Invalid email or password");
        var candidate = usersService.findByEmail(user.email()).orElse(null);
        if (candidate == null) throw exception;
        if (!passwordEncoder.matches(user.password(), candidate.getPassword())) throw exception;
        authenticate(user, request, response);
    }

    private void authenticate(LoginUser user, HttpServletRequest request, HttpServletResponse response) {
        var authToken = new UsernamePasswordAuthenticationToken(user.email(), user.password());
        var authentication = manager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwtSessionStrategy.onAuthentication(authentication, request, response);
    }
}
