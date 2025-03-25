package org.sorokovsky.lottery.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.contract.LoginUser;
import org.sorokovsky.lottery.strategy.JwtSessionStrategy;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import java.io.IOException;

@RequiredArgsConstructor
public class EmailPasswordFilter extends UsernamePasswordAuthenticationFilter {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final SessionAuthenticationStrategy jwtSessionStrategy;

    public EmailPasswordFilter(AuthenticationManager authenticationManager, JwtSessionStrategy jwtSessionStrategy) {
        super(authenticationManager);
        this.jwtSessionStrategy = jwtSessionStrategy;
        setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())) {
            try {
                LoginUser user = MAPPER.readValue(request.getInputStream(), LoginUser.class);
                var authRequest = new UsernamePasswordAuthenticationToken(user.email(), user.password());

                return getAuthenticationManager().authenticate(authRequest);
            } catch (IOException e) {
                throw new AuthenticationServiceException(e.getMessage(), e);
            }
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        jwtSessionStrategy.onAuthentication(authResult, request, response);
        chain.doFilter(request, response);
    }
}
