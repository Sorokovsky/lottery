package org.sorokovsky.lottery.deserializer;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jwt.EncryptedJWT;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorokovsky.lottery.contract.Token;

import java.text.ParseException;

@RequiredArgsConstructor
public class DefaultRefreshTokenDeserializer extends AbstractJwtDeserializer {
    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultRefreshTokenDeserializer.class);

    private final JWEDecrypter decrypter;

    @Override
    public Token apply(String string) {
        try {
            var decrypted = EncryptedJWT.parse(string);
            decrypted.decrypt(decrypter);
            var claims = decrypted.getJWTClaimsSet();
            return extractTokenFromClaims(claims);
        } catch (ParseException | JOSEException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}
