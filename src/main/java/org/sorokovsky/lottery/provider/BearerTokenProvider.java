package org.sorokovsky.lottery.provider;

import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.contract.Token;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BearerTokenProvider implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    private final UserDetailsService userDetailsService;

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken authenticationToken) throws UsernameNotFoundException {
        var exception = new UsernameNotFoundException("Username not found");
        if (!(authenticationToken.getPrincipal() instanceof Token token)) throw exception;
        return userDetailsService.loadUserByUsername(token.email());
    }
}
