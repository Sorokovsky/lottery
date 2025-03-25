package org.sorokovsky.lottery.serializer;

import com.nimbusds.jwt.JWTClaimsSet;
import org.sorokovsky.lottery.contract.Token;

import java.util.Date;

public abstract class AbstractJwtSerializer implements TokenSerializer {
    protected JWTClaimsSet generateClaims(Token token) {
        return new JWTClaimsSet.Builder()
                .jwtID(token.id().toString())
                .subject(token.email())
                .issueTime(Date.from(token.createdAt()))
                .expirationTime(Date.from(token.expiresAt()))
                .build();
    }
}
