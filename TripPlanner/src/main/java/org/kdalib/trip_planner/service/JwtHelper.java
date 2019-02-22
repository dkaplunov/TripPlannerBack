package org.kdalib.trip_planner.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtHelper {

    private final Key key;

    @Autowired
    JwtHelper () {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String createToken (Long userId) {
        return Jwts.builder().setSubject(userId.toString()).signWith(key).compact();
    }

    public Long getUserId (String token) {
        return Long.parseLong(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject());
    }
}
