package com.dinosatrovic.newsportal.users.service.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
}
