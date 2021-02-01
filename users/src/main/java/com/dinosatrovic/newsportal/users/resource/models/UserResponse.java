package com.dinosatrovic.newsportal.users.resource.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    String username;
    String firstName;
    String lastName;
    String email;
}
