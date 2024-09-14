package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    @GetMapping("/users")
    public String getAllUser() {
        System.out.println("Run getAllUser method");
        return "Successfully";
    }

}
