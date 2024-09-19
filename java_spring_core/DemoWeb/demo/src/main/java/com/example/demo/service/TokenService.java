package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Token;
import com.example.demo.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    public Long saveToken(Token token) {

        Optional<Token> token_ = tokenRepository.findByUsername(token.getUsername());

        if (token_.isEmpty()) {
            tokenRepository.save(token);
            return token.getId();
        } else {
            Token current_token = token_.get();
            current_token.setAccessToken(token.getAccessToken());
            current_token.setRefreshToken(token.getRefreshToken());
            tokenRepository.save(current_token);
            return current_token.getId();
        }
    }

    public String deleteToken(Token token) {
        tokenRepository.delete(token);
        return "success";
    }

    public Token getByUsername(String username) {
        return tokenRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Token not exist!!"));
    }

}
