package com.example.demo.dto.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class AddressDTO implements Serializable {
    private String city;
    private String province;
    private String country;
}
