package com.dinosatrovic.newsportal.articles.config;

import com.dinosatrovic.newsportal.articles.exceptions.ServiceException;
import com.dinosatrovic.newsportal.articles.exceptions.ServiceExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class MSRequestContextImpl implements MSRequestContext {

    private UUID userId;

    @Override
    public UUID getUserId() {
        return Optional.of(userId).orElseThrow(
                () -> new ServiceException(ServiceExceptionEnum.MISSING_USER_ID)
        );
    }
    @Override
    public void create(HttpServletRequest request) {
//        String jwt = request.getHeader("Authorization");
//        jwt = jwt.replace("Bearer ", "");
//        try {
//            DecodedJWT decodedJWT = JWT.decode(jwt);
//        }
//        catch (JWTDecodeException e) {
//            throw new ServiceException(ServiceExceptionEnum.JWT_INVALID)
//        }
        if(request.getHeader("x-account-id") != null)
            userId = UUID.fromString(request.getHeader("x-account-id"));
      }
}
