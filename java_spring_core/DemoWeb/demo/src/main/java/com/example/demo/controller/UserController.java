package com.example.demo.controller;

import com.example.demo.dto.request.UserRequestDetail;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value="/", headers = "apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDetail userRequestDetail) {

        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") int userId, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request update user, user " + userId);

        return "User Updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable("userId") int userId, @RequestParam(name="status", required = false, defaultValue = "false") boolean status, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request change user's status, status " + status);

        return "User changed status";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") int userId, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request delete user");

        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDetail getUser(@PathVariable("userId") int userId) {
        return new UserRequestDetail("Hieu", "Nguyen", "phone", "email");
    }

    @GetMapping("/list")
    public List<UserRequestDetail> getUserList() {
        return List.of(new UserRequestDetail("Hieu", "Nguyen", "00", "afda@gmail.com"),
                new UserRequestDetail("Dat", "Nguyen", "11", "kunno@gmail.com"));
    }

}
