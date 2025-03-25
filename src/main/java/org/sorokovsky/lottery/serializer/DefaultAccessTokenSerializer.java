package org.sorokovsky.lottery.serializer;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorokovsky.lottery.contract.Token;

@Setter
@RequiredArgsConstructor
public class DefaultAccessTokenSerializer extends AbstractJwtSerializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAccessTokenSerializer.class);

    private final JWSSigner signer;
    private JWSAlgorithm algorithm = JWSAlgorithm.HS256;

    @Override
    public String apply(Token token) {
        var header = new JWSHeader.Builder(algorithm).keyID(token.id().toString()).build();
        var claims = generateClaims(token);
        var signed = new SignedJWT(header, claims);
        try {
            signed.sign(signer);
            return signed.serialize();
        } catch (JOSEException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}
