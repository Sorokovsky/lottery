package org.sorokovsky.lottery.repository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.contract.Token;
import org.sorokovsky.lottery.deserializer.TokenDeserializer;
import org.sorokovsky.lottery.serializer.TokenSerializer;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor
public class DefaultAccessTokenRepository implements TokenRepository {
    private static final String BEARER_PREFIX = "Bearer ";
    private final TokenSerializer serializer;
    private final TokenDeserializer deserializer;

    @Override
    public void set(Token token, HttpServletResponse response) {
        var rawToken = serializer.apply(token);
        response.setHeader(HttpHeaders.AUTHORIZATION, BEARER_PREFIX + rawToken);
    }

    @Override
    public Token get(HttpServletRequest request) {
        var header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header != null && header.startsWith(BEARER_PREFIX)) {
            var rawToken = header.substring(BEARER_PREFIX.length());
            return deserializer.apply(rawToken);
        }
        return null;
    }

    @Override
    public void remove(HttpServletResponse response) {
        response.setHeader(HttpHeaders.AUTHORIZATION, null);
    }
}
