package org.sorokovsky.lottery.factory;

import lombok.Setter;
import org.sorokovsky.lottery.contract.Token;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Component
@Setter
public class RefreshTokenRecreateFactory implements AccessTokenFactory {
    private Duration lifetime = Duration.ofDays(7);

    @Override
    public Token apply(Token token) {
        var now = Instant.now();
        return new Token(
                UUID.randomUUID(),
                token.email(),
                now,
                now.plus(lifetime)
        );
    }
}
