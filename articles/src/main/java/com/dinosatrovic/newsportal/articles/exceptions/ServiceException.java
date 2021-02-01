package com.dinosatrovic.newsportal.articles.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ServiceException extends RuntimeException {
    private final ServiceExceptionEnum serviceExceptionEnum;
}
