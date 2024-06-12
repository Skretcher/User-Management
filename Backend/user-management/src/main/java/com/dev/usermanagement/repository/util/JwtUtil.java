package com.dev.usermanagement.repository.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Base64;

@Component
public class JwtUtil {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours
    private static final String SECRET_KEY = generateSecretKey();

    private static String generateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretBytes = new byte[64];
        secureRandom.nextBytes(secretBytes);
        return Base64.getEncoder().encodeToString(secretBytes);
    }

    public static String generateToken(String email , String SECRET_KEY) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static boolean validateToken(String token, String SECRET_KEY) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String extractEmail(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
}
