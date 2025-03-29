package com.huyhuynh.busserver.security.jwt;
import com.huyhuynh.busserver.model.AuthModel;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private Key getSigningKey() {
        // 32 bytes
        String SECRET_KEY = "MY_SECRET_KEY_MY_SECRET_KEY_MY_SECRET_KEY";
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public AuthModel generateToken(String username) {
        // 1 ngày
        long EXPIRATION_TIME = 86400000;
        Date expired = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        String token =  Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expired)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
        return new AuthModel(token,expired.getTime(),"Bearer ");
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}


