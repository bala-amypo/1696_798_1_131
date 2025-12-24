package com.example.demo.security;

import com.example.demo.entity.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component

public class JwtTokenProvider {

    private static final String SECRET_KEY = "secret-key-demo";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

   public String createToken(AppUser user) {

    String role = null;

    // 1️⃣ Prefer roles set (real app usage)
    if (user.getRoles() != null && !user.getRoles().isEmpty()) {
        role = user.getRoles().iterator().next().getName();
    }
    // 2️⃣ Fallback for test cases
    else if (user.getRole() != null) {
        role = user.getRole();
    }

    return Jwts.builder()
            .setSubject(user.getEmail())
            .claim("userId", user.getId())
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
}

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}