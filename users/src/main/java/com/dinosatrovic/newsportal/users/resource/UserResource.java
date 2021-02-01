package com.dinosatrovic.newsportal.users.resource;

import com.dinosatrovic.newsportal.users.resource.models.UserAuthResponse;
import com.dinosatrovic.newsportal.users.resource.models.UserResponse;
import com.dinosatrovic.newsportal.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping(value = "/auth", produces = "application/json")
    public ResponseEntity<UserAuthResponse> getUser(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(userService.getUserAuthInfoByUsername(username));
    }
}
