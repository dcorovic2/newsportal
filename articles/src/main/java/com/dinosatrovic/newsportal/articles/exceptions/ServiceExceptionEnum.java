package com.dinosatrovic.newsportal.articles.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ServiceExceptionEnum {
    ARTICLE_NOT_FOUND("Article with provided is not found", 404),
    MISSING_USER_ID("User id header not provided", 400);

    private String errorMessage;
    private Integer errorCode;
}
