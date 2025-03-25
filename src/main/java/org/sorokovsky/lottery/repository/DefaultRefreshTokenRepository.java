package org.sorokovsky.lottery.repository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.contract.Token;
import org.sorokovsky.lottery.deserializer.TokenDeserializer;
import org.sorokovsky.lottery.serializer.TokenSerializer;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Data
@RequiredArgsConstructor
public class DefaultRefreshTokenRepository implements TokenRepository {
    private final TokenSerializer serializer;
    private final TokenDeserializer deserializer;
    private String cookieName = "refresh_token";

    @Override
    public void set(Token token, HttpServletResponse response) {
        int maxAge = (int) ChronoUnit.SECONDS.between(token.createdAt(), token.expiresAt());
        response.addCookie(generateCookie(serializer.apply(token), maxAge));
    }

    @Override
    public Token get(HttpServletRequest request) {
        var rawToken = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
        if (rawToken != null) {
            return deserializer.apply(rawToken);
        }
        return null;
    }

    @Override
    public void remove(HttpServletResponse response) {
        response.addCookie(generateCookie("", 0));
    }

    private Cookie generateCookie(String token, int maxAge) {
        Cookie cookie = new Cookie(cookieName, token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setDomain(null);
        cookie.setSecure(false);
        cookie.setMaxAge(maxAge);
        return cookie;
    }
}
