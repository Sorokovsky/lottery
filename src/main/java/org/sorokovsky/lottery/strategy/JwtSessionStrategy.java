package org.sorokovsky.lottery.strategy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.factory.AccessTokenFactory;
import org.sorokovsky.lottery.factory.RefreshTokenFactory;
import org.sorokovsky.lottery.repository.TokenRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@RequiredArgsConstructor
public class JwtSessionStrategy implements SessionAuthenticationStrategy {
    private final TokenRepository accessTokenRepository;
    private final TokenRepository refreshTokenRepository;
    private final AccessTokenFactory accessTokenFactory;
    private final RefreshTokenFactory refreshTokenFactory;

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response)
            throws SessionAuthenticationException {
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            var refreshToken = refreshTokenFactory.apply(authentication);
            var accessToken = accessTokenFactory.apply(refreshToken);
            accessTokenRepository.set(accessToken, response);
            refreshTokenRepository.set(refreshToken, response);
        }
    }
}
