package com.dinosatrovic.newsportal.articles.resource.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ArticleResponse {
    private String id;
    private String title;
    private String content;
    private UUID createdBy;
    private UUID editedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
