package org.sorokovsky.lottery.factory;

import lombok.Setter;
import org.sorokovsky.lottery.contract.Token;
import org.springframework.security.core.Authentication;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Setter
public class DefaultRefreshTokenFactory implements RefreshTokenFactory {
    private Duration lifetime = Duration.ofDays(7);

    @Override
    public Token apply(Authentication authentication) {
        var now = Instant.now();
        return new Token(UUID.randomUUID(), authentication.getName(), now, now.plus(lifetime));
    }
}
