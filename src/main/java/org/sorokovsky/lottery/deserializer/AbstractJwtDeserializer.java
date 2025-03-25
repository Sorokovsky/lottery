package org.sorokovsky.lottery.deserializer;

import com.nimbusds.jwt.JWTClaimsSet;
import org.sorokovsky.lottery.contract.Token;

import java.util.UUID;

public abstract class AbstractJwtDeserializer implements TokenDeserializer {
    protected Token extractTokenFromClaims(JWTClaimsSet claims) {
        return new Token(
                UUID.fromString(claims.getJWTID()),
                claims.getSubject(),
                claims.getIssueTime().toInstant(),
                claims.getExpirationTime().toInstant()
        );
    }
}
