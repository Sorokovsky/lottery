package org.sorokovsky.lottery.factory;

import lombok.Setter;
import org.sorokovsky.lottery.contract.Token;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Setter
public class DefaultAccessTokenFactory implements AccessTokenFactory {
    private Duration lifetime = Duration.ofMinutes(15);

    @Override
    public Token apply(Token token) {
        var now = Instant.now();
        return new Token(UUID.randomUUID(), token.email(), now, now.plus(lifetime));
    }
}
