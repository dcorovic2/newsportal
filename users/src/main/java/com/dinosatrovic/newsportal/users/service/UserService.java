package com.dinosatrovic.newsportal.users.service;

import com.dinosatrovic.newsportal.users.resource.models.UserAuthResponse;
import com.dinosatrovic.newsportal.users.resource.models.UserResponse;

import java.util.UUID;

public interface UserService {
    UserResponse getUserById(UUID userId);
    UserAuthResponse getUserAuthInfoByUsername(String username);
}
