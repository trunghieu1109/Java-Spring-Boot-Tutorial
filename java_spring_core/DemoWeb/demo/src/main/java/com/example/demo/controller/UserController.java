package com.example.demo.controller;

import com.example.demo.dto.request.UserRequestDetail;
import com.example.demo.dto.response.ResponseData;
import com.example.demo.dto.response.ResponseSuccess;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping(value="/", headers = "apiKey=v1.0")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<Long> addUser(@Valid @RequestBody UserRequestDetail userRequestDetail) {
        log.info("Add user to database");

        try {
            long userId = userService.addUser(userRequestDetail);
            return new ResponseData<>(HttpStatus.CREATED.value(), "User has been created", userId);
        } catch (Exception e) {
            log.error("Cant add user to database, exception: ", e.getMessage(), e.getCause());

            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), "Add user fail");
        }
    }

    @PutMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess updateUser(@PathVariable("userId") int userId, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request update user, user " + userId);

        return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated");
    }

    @PatchMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess changeStatus(@Min(1) @PathVariable("userId") int userId, @RequestParam(name="status", required = false, defaultValue = "false") boolean status, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request change user's status, status " + status);

        return new ResponseSuccess(HttpStatus.ACCEPTED, "User'status changed");
    }

    @DeleteMapping("/{userId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseSuccess deleteUser(@Min(1) @PathVariable("userId") int userId, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request delete user");

        return new ResponseSuccess(HttpStatus.NO_CONTENT, "User deleted");
    }

    @GetMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseData<UserRequestDetail> getUser(@PathVariable("userId") int userId) {
        return new ResponseData<>(HttpStatus.OK.value(), "Get successfully", new UserRequestDetail("Hieu", "Nguyen", "phone", "email"));
    }

    @Operation(summary = "summary", description = "Get a list of user details", responses = {
            @ApiResponse(responseCode = "202", description = "Get list successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "ex name", summary = "ex summary",
                                    value = """
                                            {
                                              "status": 200,
                                              "message": "Get list",
                                              "data": [
                                                {
                                                  "firstName": "Hieu",
                                                  "lastName": "Nguyen",
                                                  "phone": "00",
                                                  "email": "afda@gmail.com",
                                                  "address": null,
                                                  "dateOfBirth": null,
                                                  "status": null
                                                },
                                                {
                                                  "firstName": "Dat",
                                                  "lastName": "Nguyen",
                                                  "phone": "11",
                                                  "email": "kunno@gmail.com",
                                                  "address": null,
                                                  "dateOfBirth": null,
                                                  "status": null
                                                }
                                              ]
                                            }
                                            """))
            )})
    @GetMapping("/list")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getUserList() {

        ResponseSuccess responseSuccess = new ResponseSuccess(HttpStatus.OK, "Get list", List.of(new UserRequestDetail("Hieu", "Nguyen", "00", "afda@gmail.com"),
                new UserRequestDetail("Dat", "Nguyen", "11", "kunno@gmail.com")));

        return responseSuccess;
    }

}
