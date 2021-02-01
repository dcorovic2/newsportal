package com.dinosatrovic.newsportal.authserver.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dinosatrovic.newsportal.authserver.resource.models.AccessTokenResponse;
import com.dinosatrovic.newsportal.authserver.resource.models.UserInfo;
import com.dinosatrovic.newsportal.authserver.service.connector.UsersConnector;
import com.dinosatrovic.newsportal.authserver.service.connector.model.UserAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final UsersConnector usersConnector;

    @Value("${jwt.secret}")
    String jwtSecret;

    @Override
    public AccessTokenResponse authenticate(UserInfo userInfo) {
        //TODO check 404 return 401
        UserAuthResponse authResponse = usersConnector.getUser(userInfo.getUsername());
        //TODO we should compare hashes here
        if(authResponse.getPassword().equals(userInfo.getPassword())) {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String jwt =  JWT.create()
                    .withClaim("userId", authResponse.getId().toString())
                    .withClaim("role", authResponse.getRole())
                    .sign(algorithm);
            return new AccessTokenResponse().setAccessToken(jwt);
        }
        else {
            //TODO 401
            throw new RuntimeException();
        }
    }
}
