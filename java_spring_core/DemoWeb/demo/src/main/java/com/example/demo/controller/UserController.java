package com.example.demo.controller;

import com.example.demo.dto.request.UserRequestDetail;
import com.example.demo.dto.response.*;
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
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
        log.info("Adding user to database");

        try {
            long userId = userService.addUser(userRequestDetail);
            return new ResponseData<>(HttpStatus.CREATED.value(), "Add user successfully", userId);
        } catch (Exception e) {
            log.error("can't get user", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Can't add user");
        }
    }

    @PutMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseData<Long> updateUser(@PathVariable("userId") int userId, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request update user, user " + userId);

        try {
            userService.updateUser(userId, userRequestDetail);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated");
        } catch(Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Reject updating request");
        }
    }

    @PatchMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess changeStatus(@Min(1) @PathVariable("userId") int userId, @RequestParam(name="status", required = false, defaultValue = "false") boolean status, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request change user's status, status " + status);

        return new ResponseSuccess(HttpStatus.ACCEPTED, "User'status changed");
    }

    @DeleteMapping("/{userId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseData<Long> deleteUser(@Min(1) @PathVariable("userId") int userId, @RequestBody UserRequestDetail userRequestDetail) {

        System.out.println("Request delete user");

        try {
            userService.deleteUser(userId);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted");
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Cant delete user");
        }
    }

    @GetMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseData<UserDetailResponse> getUser(@PathVariable("userId") int userId) {

        try {
            UserDetailResponse userDetailResponse = userService.getUser(userId);
            return new ResponseData<>(HttpStatus.OK.value(), "Get user successfully", userDetailResponse);
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }


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
    public ResponseData<PageResponse> getUserList(int pageNo, int pageSize) {

        log.info("Get user");
        return new ResponseData<>(HttpStatus.OK.value(), "Get list successfully", userService.getAllUsers(pageNo, pageSize));
    }

    @GetMapping("/list-search")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseData<PageResponse> getUserList(int pageNo, int pageSize, String search) {

        log.info("Get user by search");
        return new ResponseData<>(HttpStatus.OK.value(), "Get list successfully", userService.getAllUsersBySearch(pageNo, pageSize, search));
    }

    @GetMapping("/list-search-criteria")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseData<PageResponse> getUserList(int pageNo, int pageSize, String... search) {

        log.info("Get user by search");
        return new ResponseData<>(HttpStatus.OK.value(), "Get list successfully", userService.getAllUsersByCriteria(pageNo, pageSize, search));
    }

}
