package com.example.demo.service;

import com.example.demo.utils.TokenType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public interface JwtService {

    public String generateToken(UserDetails userDetails);

    public String generateRefreshToken(UserDetails userDetails);

    String extractUsername(String token, TokenType type);

    boolean isValid(String token, TokenType type, UserDetails userDetails);

}
