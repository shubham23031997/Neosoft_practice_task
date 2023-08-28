package com.example.Authentication.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTService {
    // This is a secret key used for signing and verifying the JWT token. 64 characters, which makes it a 256-bi
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    // This method generates a JWT token for a given user.
    public String generateToken(String userName) {
        // Create an empty set of claims (payload) for the token.
        Map<String, Object> claims = new HashMap<>();
        // Call the createToken method to generate the token and return it.
        return createToken(claims, userName);
    }

    // This method is used to validate and parse a JWT token.
    public void validateToken(final String token) {
        // Parse the token using the provided secret key.
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(getSignKey()) // Set the signing key to verify the token's signature.
                .build()
                .parseClaimsJws(token); // Parse the token and obtain its claims.
        // Note: If the token is invalid or expired, it will throw an exception.
    }

    // This method retrieves the signing key from the secret.
    private Key getSignKey() {
        // Decode the secret key from base64 encoding into bytes.
        byte[] keyByte = Decoders.BASE64.decode(SECRET);
        // Create and return a signing key using the decoded bytes.
        return Keys.hmacShaKeyFor(keyByte);
    }

    // This method creates a JWT token.
    private String createToken(Map<String, Object> claims, String userName) {
        // Build a JWT token with the specified claims.
        return Jwts.builder()
                .setClaims(claims) // Set the claims (payload) for the token.
                .setSubject(userName) // Set the subject (typically the username) of the token.
                .setIssuedAt(new Date(System.currentTimeMillis())) // Set the token's issuance date.
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // Set token expiration (30 minutes from now).
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // Sign the token using the signing key.
                .compact(); // Compact the token into a string representation.
    }

}

