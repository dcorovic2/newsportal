package com.dinosatrovic.newsportal.users.resource.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserAuthResponse {
    private UUID id;
    private String username;
    private String password;
    private String role;
}
