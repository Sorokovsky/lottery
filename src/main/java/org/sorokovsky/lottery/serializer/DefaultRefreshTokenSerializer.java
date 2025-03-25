package org.sorokovsky.lottery.serializer;

import com.nimbusds.jose.*;
import com.nimbusds.jwt.EncryptedJWT;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorokovsky.lottery.contract.Token;

@Setter
@RequiredArgsConstructor
public class DefaultRefreshTokenSerializer extends AbstractJwtSerializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRefreshTokenSerializer.class);
    private final JWEEncrypter encrypter;
    private JWEAlgorithm algorithm = JWEAlgorithm.DIR;
    private EncryptionMethod encryptionMethod = EncryptionMethod.A192CBC_HS384;

    @Override
    public String apply(Token token) {
        var header = new JWEHeader.Builder(algorithm, encryptionMethod).keyID(token.id().toString()).build();
        var claims = generateClaims(token);
        var encrypted = new EncryptedJWT(header, claims);
        try {
            encrypted.encrypt(encrypter);
            return encrypted.serialize();
        } catch (JOSEException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}
