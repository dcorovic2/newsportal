package com.dinosatrovic.newsportal.authserver.service.connector;

import com.dinosatrovic.newsportal.authserver.service.connector.model.UserAuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("users-microservice")
public interface UsersConnector {

    @GetMapping("/user/auth")
    UserAuthResponse getUser(@RequestParam String username);
}
