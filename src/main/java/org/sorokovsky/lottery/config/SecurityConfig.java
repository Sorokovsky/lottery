package org.sorokovsky.lottery.config;

import org.sorokovsky.lottery.configurer.JwtConfigurer;
import org.sorokovsky.lottery.deserializer.DefaultAccessTokenDeserializer;
import org.sorokovsky.lottery.deserializer.DefaultRefreshTokenDeserializer;
import org.sorokovsky.lottery.entrypoints.UnauthorizedEntryPoint;
import org.sorokovsky.lottery.factory.DefaultAccessTokenFactory;
import org.sorokovsky.lottery.factory.DefaultRefreshTokenFactory;
import org.sorokovsky.lottery.provider.BearerTokenProvider;
import org.sorokovsky.lottery.repository.DefaultAccessTokenRepository;
import org.sorokovsky.lottery.repository.DefaultRefreshTokenRepository;
import org.sorokovsky.lottery.serializer.DefaultAccessTokenSerializer;
import org.sorokovsky.lottery.serializer.DefaultRefreshTokenSerializer;
import org.sorokovsky.lottery.service.LotteryUserDetailService;
import org.sorokovsky.lottery.strategy.JwtSessionStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

@Configuration

public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DefaultAccessTokenRepository accessTokenRepository(
            DefaultAccessTokenSerializer accessTokenSerializer,
            DefaultAccessTokenDeserializer accessTokenDeserializer
    ) {
        return new DefaultAccessTokenRepository(accessTokenSerializer, accessTokenDeserializer);
    }

    @Bean
    public DefaultRefreshTokenRepository refreshTokenRepository(
            DefaultRefreshTokenSerializer refreshTokenSerializer,
            DefaultRefreshTokenDeserializer refreshTokenDeserializer
    ) {
        return new DefaultRefreshTokenRepository(refreshTokenSerializer, refreshTokenDeserializer);
    }

    @Bean
    public AuthenticationManager authenticationManager(
            PasswordEncoder passwordEncoder,
            LotteryUserDetailService userDetailsService,
            BearerTokenProvider bearerTokenProvider
    ) {
        var provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        var preAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
        preAuthenticationProvider.setPreAuthenticatedUserDetailsService(bearerTokenProvider);
        return new ProviderManager(provider, preAuthenticationProvider);
    }

    @Bean
    public JwtSessionStrategy jwtSessionStrategy(
            DefaultAccessTokenRepository accessTokenRepository,
            DefaultRefreshTokenRepository refreshTokenRepository) {
        return new JwtSessionStrategy(accessTokenRepository, refreshTokenRepository, new DefaultAccessTokenFactory(), new DefaultRefreshTokenFactory());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            AuthenticationManager authenticationManager,
            DefaultAccessTokenRepository accessTokenRepository,
            JwtSessionStrategy jwtSessionStrategy
    ) throws Exception {
        var jwtConfigurer = new JwtConfigurer(authenticationManager, accessTokenRepository);
        http.apply(jwtConfigurer);
        return http
                .authorizeHttpRequests(request -> request
                        .requestMatchers(
                                "/auth/refresh-tokens",
                                "/auth/register",
                                "/auth/login",
                                "/v3/**",
                                "/swagger-ui/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(x -> x
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .addSessionAuthenticationStrategy(jwtSessionStrategy)
                )
                .exceptionHandling(config -> config
                        .authenticationEntryPoint(new UnauthorizedEntryPoint()))
                .build();
    }
}
