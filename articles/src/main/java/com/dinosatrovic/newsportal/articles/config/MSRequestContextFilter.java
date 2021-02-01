package com.dinosatrovic.newsportal.articles.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Order(1)
public class MSRequestContextFilter extends OncePerRequestFilter {

    private final MSRequestContext context;

    public MSRequestContextFilter(MSRequestContext context) {
        this.context = context;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        context.create(request);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.debug("Destroying WebFilter >> ");
    }

}
