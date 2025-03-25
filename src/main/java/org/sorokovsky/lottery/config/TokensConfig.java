package org.sorokovsky.lottery.config;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import org.sorokovsky.lottery.deserializer.DefaultAccessTokenDeserializer;
import org.sorokovsky.lottery.deserializer.DefaultRefreshTokenDeserializer;
import org.sorokovsky.lottery.serializer.DefaultAccessTokenSerializer;
import org.sorokovsky.lottery.serializer.DefaultRefreshTokenSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class TokensConfig {
    @Bean
    public DefaultAccessTokenSerializer accessTokenSerializer(
            @Value("${jwt.access-token-key:}") String accessTokenKey
    ) throws ParseException, KeyLengthException {
        return new DefaultAccessTokenSerializer(
                new MACSigner(OctetSequenceKey.parse(accessTokenKey))
        );
    }

    @Bean
    public DefaultAccessTokenDeserializer accessTokenDeserializer(
            @Value("${jwt.access-token-key:}") String accessTokenKey
    ) throws ParseException, JOSEException {
        return new DefaultAccessTokenDeserializer(
                new MACVerifier(
                        OctetSequenceKey.parse(accessTokenKey)
                )
        );
    }

    @Bean
    public DefaultRefreshTokenSerializer refreshTokenSerializer(
            @Value("${jwt.refresh-token-key:}") String refreshTokenKey
    ) throws ParseException, KeyLengthException {
        return new DefaultRefreshTokenSerializer(
                new DirectEncrypter(
                        OctetSequenceKey.parse(refreshTokenKey)
                )
        );
    }

    @Bean
    public DefaultRefreshTokenDeserializer refreshTokenDeserializer(
            @Value("${jwt.refresh-token-key:}") String refreshTokenKey
    ) throws ParseException, JOSEException {
        return new DefaultRefreshTokenDeserializer(
                new DirectDecrypter(
                        OctetSequenceKey.parse(refreshTokenKey)
                )
        );
    }
}
