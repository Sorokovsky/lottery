package org.sorokovsky.lottery.deserializer;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorokovsky.lottery.contract.Token;

import java.text.ParseException;

@RequiredArgsConstructor
public class DefaultAccessTokenDeserializer extends AbstractJwtDeserializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAccessTokenDeserializer.class);

    private final JWSVerifier verifier;

    @Override
    public Token apply(String string) {
        try {
            var signed = SignedJWT.parse(string);
            signed.verify(verifier);
            var claims = signed.getJWTClaimsSet();
            return extractTokenFromClaims(claims);
        } catch (ParseException | JOSEException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}
