package com.example.ApiGateWay.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;

@Component
public class JWTUtil {
    // This is a secret key used for signing and verifying the JWT token. 64 characters, which makes it a 256-bi
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    // This method retrieves the signing key from the secret.
    private Key getSignKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public String validateToken(final String token) {
//        // Parse the token using the provided secret key.
//        Jws<Claims> claimsJws = Jwts.parserBuilder()
//                .setSigningKey(getSignKey()) // Set the signing key to verify the token's signature.
//                .build()
//                .parseClaimsJws(token); // Parse the token and obtain its claims.
        // Note: If the token is invalid or expired, it will throw an exception.

        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token);

            // Extract the roles claim from the token's claims
            List<String> roles = claimsJws.getBody().get("roles", List.class);

            if (roles != null && !roles.isEmpty()) {
                return roles.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

