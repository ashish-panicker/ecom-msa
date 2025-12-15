package com.example.authservice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    private final String secret = "very-secret-key-for-training";
    private final long expirationSeconds = 3600;

    public String generateToken(String username, String role) {

        Instant now = Instant.now();

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(expirationSeconds)))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    public long getExpirationSeconds() {
        return expirationSeconds;
    }
}
