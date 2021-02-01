package com.dinosatrovic.newsportal.articles.resource.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class FullArticleResponse {
    private String id;
    private String title;
    private String content;
    private UserResponse createdByUser;
    private UserResponse editedByUser;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
