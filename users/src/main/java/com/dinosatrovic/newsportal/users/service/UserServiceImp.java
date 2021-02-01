package com.dinosatrovic.newsportal.users.service;

import com.dinosatrovic.newsportal.users.resource.models.UserAuthResponse;
import com.dinosatrovic.newsportal.users.resource.models.UserResponse;
import com.dinosatrovic.newsportal.users.db.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    public UserResponse getUserById(UUID userId) {
       return objectMapper.convertValue(userRepository.findById(userId), UserResponse.class);
    }

    @Override
    public UserAuthResponse getUserAuthInfoByUsername(String username) {
        return objectMapper.convertValue(userRepository.findByUsername(username), UserAuthResponse.class);
    }
}
