package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDetail;
import com.example.demo.dto.response.PageResponse;
import com.example.demo.dto.response.UserDetailResponse;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.SearchRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final SearchRepository searchRepository;


    @Override
    public Long addUser(UserRequestDetail userRequestDetail) {
        User user = User.builder()
                .firstName(userRequestDetail.getFirstName())
                .lastName(userRequestDetail.getLastName())
                .dateOfBirth(userRequestDetail.getDateOfBirth())
                .username(userRequestDetail.getFirstName() + userRequestDetail.getLastName())
                .password(userRequestDetail.getEmail())
                .build();

        userRequestDetail.getAddress().forEach(address -> {
            user.saveAddress(Address.builder()
                            .city(address.getCity())
                            .province(address.getProvince())
                            .country(address.getCountry())
                            .build());
        });

        userRepository.save(user);

        return user.getId();
    }

    @Override
    public void updateUser(long userId, UserRequestDetail userRequestDetail) {
        User user = getUserById(userId);
        user.setFirstName(userRequestDetail.getFirstName());
        user.setLastName(userRequestDetail.getLastName());
        user.setUsername(userRequestDetail.getFirstName() + userRequestDetail.getLastName());
        user.setPassword(userRequestDetail.getEmail());

        userRepository.save(user);

        log.info("User updated successfully");

    }

    @Override
    public void changeStatus(long userId, UserRequestDetail userRequestDetail) {

    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
        log.info("User deleted");
    }

    @Override
    public UserDetailResponse getUser(long userId) {

        User user = getUserById(userId);

        return UserDetailResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Override
    public PageResponse<?> getAllUsers(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

//        Pageable pageable1 = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, "field"));

        Page<User> users = userRepository.findAll(pageable);

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage(users.getTotalPages())
                .list(users.stream().map(user -> UserDetailResponse.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build()).toList())
                .build();
    }

    public PageResponse<?> getAllUsersBySearch(int pageNo, int pageSize, String search) {

        return searchRepository.findBySearch(pageNo, pageSize, search);
    }

    public PageResponse<?> getAllUsersByCriteria(int pageNo, int pageSize, String... search) {

        return searchRepository.findByCriteria(pageNo, pageSize, search);
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceAccessException("Cant access to database"));
    }
}
