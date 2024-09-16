package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDetail;
import com.example.demo.dto.response.UserDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    long addUser(UserRequestDetail userRequestDetail);
    void updateUser(long userId, UserRequestDetail userRequestDetail);
    void changeStatus(long userId, UserRequestDetail userRequestDetail);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);
    List<UserDetailResponse> getAllUsers(int pageNo, int pageSize);
}
