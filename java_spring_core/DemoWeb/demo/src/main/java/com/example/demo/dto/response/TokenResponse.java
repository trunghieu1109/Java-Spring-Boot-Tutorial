package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class TokenResponse implements Serializable {

    private String accessToken;    // token to access

    private String refreshToken;   // token to refresh access token

    private Long userId;

}
