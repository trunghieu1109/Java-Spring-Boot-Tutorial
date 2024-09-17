package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
public class UserDetailResponse implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
