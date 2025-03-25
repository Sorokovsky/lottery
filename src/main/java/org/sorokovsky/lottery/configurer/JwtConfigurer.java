package org.sorokovsky.lottery.configurer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sorokovsky.lottery.converter.BearerAuthorizationTokenConverter;
import org.sorokovsky.lottery.repository.TokenRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.csrf.CsrfFilter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class JwtConfigurer implements SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {
    private AuthenticationManager authenticationManager;
    private TokenRepository tokenRepository;

    @Override
    public void init(HttpSecurity builder) {

    }

    @Override
    public void configure(HttpSecurity builder) {
        var bearerAuthorizationConverter = new BearerAuthorizationTokenConverter(tokenRepository);
        var authenticationFilter = new AuthenticationFilter(authenticationManager, bearerAuthorizationConverter);
        authenticationFilter.setSuccessHandler((request, response, authentication) -> {
        });
        authenticationFilter.setFailureHandler(new AuthenticationEntryPointFailureHandler(new Http403ForbiddenEntryPoint()));
        builder.addFilterBefore(authenticationFilter, CsrfFilter.class);
    }
}
