package org.sorokovsky.lottery;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.repository.TokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class AccessTokenRetranslationFilter extends OncePerRequestFilter {
    private final TokenRepository accessTokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = accessTokenRepository.get(request);
        if (token != null) accessTokenRepository.set(token, response);
        filterChain.doFilter(request, response);
    }
}
