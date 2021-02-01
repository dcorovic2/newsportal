package com.dinosatrovic.newsportal.articles.resource.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateArticleRequest {
    private String title;
    private String content;
}
