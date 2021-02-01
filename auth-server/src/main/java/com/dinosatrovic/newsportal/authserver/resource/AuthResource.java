package com.dinosatrovic.newsportal.authserver.resource;

import com.dinosatrovic.newsportal.authserver.resource.models.AccessTokenResponse;
import com.dinosatrovic.newsportal.authserver.resource.models.UserInfo;
import com.dinosatrovic.newsportal.authserver.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthResource {

    private final AuthService authService;

    @PostMapping("/")
    AccessTokenResponse getAccesToken(@RequestBody UserInfo userInfo) {
        return authService.authenticate(userInfo);
    }

}
