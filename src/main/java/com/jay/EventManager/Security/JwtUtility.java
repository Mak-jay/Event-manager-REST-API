package com.jay.EventManager.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;


@Component
public class JwtUtility {

    private KeyPair keyPair;

    @PostConstruct
    public void init() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(2048);
        this.keyPair = keyGenerator.generateKeyPair();
    }
    @Bean
    public KeyPair keyPair() {
        return this.keyPair;
    }

    public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
        Algorithm algorithm = Algorithm.RSA256(
                (RSAPublicKey) keyPair.getPublic(),
                (RSAPrivateKey) keyPair.getPrivate()
        );
        return JWT.create()
                .withSubject("User Details")
                .withClaim("email", email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .withIssuer("Event Scheduler")
                .sign(algorithm);
    }

    public String validateTokenAndRetrieveSubject(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.RSA256(
                (RSAPublicKey) keyPair.getPublic(),
                null
        );

        JWTVerifier verifier = JWT.require(algorithm)
                .withSubject("User Details")
                .withIssuer("Event Scheduler")
                .build();

        DecodedJWT jwt = verifier.verify(token);

        return jwt.getClaim("email").asString();
    }
}
