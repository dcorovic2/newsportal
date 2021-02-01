package com.dinosatrovic.newsportal.articles.config;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public interface MSRequestContext {

    UUID getUserId();
    void create(HttpServletRequest request);

}
