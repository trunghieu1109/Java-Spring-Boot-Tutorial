package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDetail;
import com.example.demo.dto.response.UserDetailResponse;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public long addUser(UserRequestDetail userRequestDetail) {
        User user = User.builder()
                .firstName(userRequestDetail.getFirstName())
                .lastName(userRequestDetail.getLastName())
                .dateOfBirth(userRequestDetail.getDateOfBirth())
                .userName(userRequestDetail.getFirstName() + userRequestDetail.getLastName())
                .passWord(userRequestDetail.getEmail())
                .build();

        userRequestDetail.getAddress().forEach(address -> {
            user.saveAddress(Address.builder()
                            .city(address.getCity())
                            .province(address.getProvince())
                            .country(address.getCountry())
                            .build());
        });

        userRepository.save(user);

        log.info("Create user successfully");

        return user.getId();
    }

    @Override
    public void updateUser(long userId, UserRequestDetail userRequestDetail) {

    }

    @Override
    public void changeStatus(long userId, UserRequestDetail userRequestDetail) {

    }

    @Override
    public void deleteUser(long userId) {

    }

    @Override
    public UserDetailResponse getUser(long userId) {
        return null;
    }

    @Override
    public List<UserDetailResponse> getAllUsers(int pageNo, int pageSize) {
        return List.of();
    }
}
