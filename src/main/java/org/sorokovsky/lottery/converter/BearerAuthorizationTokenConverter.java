package org.sorokovsky.lottery.converter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.repository.TokenRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

@RequiredArgsConstructor
public class BearerAuthorizationTokenConverter implements AuthenticationConverter {
    private final TokenRepository bearerTokenRepository;

    @Override
    public Authentication convert(HttpServletRequest request) {
        var token = bearerTokenRepository.get(request);
        if (token == null) return null;
        return new PreAuthenticatedAuthenticationToken(token, token);
    }
}
