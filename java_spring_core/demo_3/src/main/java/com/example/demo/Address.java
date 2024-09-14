package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class Address {
    private String city;
    private String state;
    private String country;

    public Address() {

    }

    public Address(String city, String state, String country) {
        super();
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // public String toString() {
    // return city + " " + state + " " + country;
    // }
}