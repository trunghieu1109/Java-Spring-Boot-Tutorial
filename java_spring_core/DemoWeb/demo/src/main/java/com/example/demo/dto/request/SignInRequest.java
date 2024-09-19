package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SignInRequest implements Serializable {

    @NotBlank(message="user name must be not null")
    private String username;

    @NotBlank(message="user name must be not null")
    private String password;

    @NotNull(message="user name must be not null")
    private Platform platform;

    private String deviceToken;

    private String version;
}
