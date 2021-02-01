package com.dinosatrovic.newsportal.articles.resource.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UpdateArticleRequest {
   private UUID id;
   private String title;
   private String content;
}
