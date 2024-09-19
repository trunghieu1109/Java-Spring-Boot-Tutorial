package com.example.demo.service;

import com.example.demo.dto.request.SignInRequest;
import com.example.demo.dto.response.TokenResponse;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final TokenService tokenService;

    public TokenResponse authentication(SignInRequest signInRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        var user = userRepository.findByUsername(signInRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Cant get user by user name"));

        String accessToken = jwtService.generateToken(user);

        String refreshToken = jwtService.generateRefreshToken(user);

        // save token to database
        tokenService.saveToken(Token.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .username(signInRequest.getUsername())
                        .build());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .build();

    }

    public TokenResponse refresh(HttpServletRequest request) {

        // validate token
        String refreshToken = request.getHeader("Referer");

        if (refreshToken == null || refreshToken.isEmpty()) {
            throw new InvalidDataAccessApiUsageException("token must be not blank");
        }

        // extract username
        final String username = jwtService.extractUsername(refreshToken, TokenType.REFRESH_TOKEN);

        var user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found in database"));

        // validate token with user details
        if (!jwtService.isValid(refreshToken, TokenType.REFRESH_TOKEN, user)) {
            throw new InvalidDataAccessApiUsageException("Token invalid");
        }

        // generate new access token
        String accessToken = jwtService.generateToken(user);

        tokenService.saveToken(Token.builder()
                        .username(username)
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build());

        // save token to database

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .build();
    }

    public String logout(HttpServletRequest request) {

        String token = request.getHeader("Referer");

        if (token == null || token.isEmpty()) {
            throw new InvalidDataAccessApiUsageException("token must be not blank");
        }

        // delete token from database
        String username = jwtService.extractUsername(token, TokenType.ACCESS_TOKEN);

        // check token whether exist in db or not. If not, throw exception
        Token currentToken = tokenService.getByUsername(username);

        tokenService.deleteToken(currentToken);

        return "Deleted";
    }

}
