package com.dinosatrovic.newsportal.articles.service.connector;

import com.dinosatrovic.newsportal.articles.resource.models.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("users-microservice")
public interface UsersConnector {

    @GetMapping("/user/{userId}")
    UserResponse getUser(@PathVariable UUID userId);
}
