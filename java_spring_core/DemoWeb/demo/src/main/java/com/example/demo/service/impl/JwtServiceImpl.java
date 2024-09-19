package com.example.demo.service.impl;

import com.example.demo.service.JwtService;
import com.example.demo.utils.TokenType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.example.demo.utils.TokenType.ACCESS_TOKEN;
import static com.example.demo.utils.TokenType.REFRESH_TOKEN;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.expirationHour}")
    private long expirationHour;

    @Value("${jwt.expirationDay}")
    private long expirationDay;

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.refreshKey}")
    private String refrestKey;

    @Override
    public String generateToken(UserDetails userDetails) {

        return generateToken(new HashMap<>(), userDetails);
    }

    @Override
    public String generateRefreshToken(UserDetails userDetails) {
        return generateRefreshToken(new HashMap<>(), userDetails);
    }

    @Override
    public String extractUsername(String token, TokenType type) {

        return extractClaim(token, type, Claims::getSubject);
    }

    private boolean isExpired(String token, TokenType type) {
        return extractExpirationDay(token, type).before(new Date());
    }

    private Date extractExpirationDay(String token, TokenType type) {
        return extractClaim(token, type, Claims::getExpiration);
    }

    @Override
    public boolean isValid(String token, TokenType type, UserDetails userDetails) {

        final String username = extractUsername(token, type);

        return username.equals(userDetails.getUsername()) && !isExpired(token, type);
    }

    private String generateToken(Map<String, Object> claims, UserDetails userDetails) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * expirationHour))
                .signWith(getKey(ACCESS_TOKEN), SignatureAlgorithm.HS256)
                .compact();

    }

    private String generateRefreshToken(Map<String, Object> claims, UserDetails userDetails) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * expirationDay))
                .signWith(getKey(REFRESH_TOKEN), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getKey(TokenType type) {

        byte[] keyBytes = null;

        if (ACCESS_TOKEN.equals(type)) {
            keyBytes = Decoders.BASE64.decode(secretKey);
        } else {
            keyBytes = Decoders.BASE64.decode(refrestKey);
        }

        return Keys.hmacShaKeyFor(keyBytes);
    }

    private <T> T extractClaim(String token, TokenType type, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token, type);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token, TokenType type) {
        return Jwts.parserBuilder().setSigningKey(getKey(type)).build().parseClaimsJws(token).getBody();
    }


}
