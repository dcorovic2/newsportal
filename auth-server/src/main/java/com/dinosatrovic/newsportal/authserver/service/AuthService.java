package com.dinosatrovic.newsportal.authserver.service;

import com.dinosatrovic.newsportal.authserver.resource.models.AccessTokenResponse;
import com.dinosatrovic.newsportal.authserver.resource.models.UserInfo;

public interface AuthService {

    AccessTokenResponse authenticate(UserInfo userInfo);
}
