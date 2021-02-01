package com.dinosatrovic.newsportal.articles.service;

import com.dinosatrovic.newsportal.articles.resource.models.ArticleResponse;
import com.dinosatrovic.newsportal.articles.resource.models.FullArticleResponse;
import com.dinosatrovic.newsportal.articles.resource.models.UpdateArticleRequest;
import com.dinosatrovic.newsportal.articles.resource.models.CreateArticleRequest;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    List<ArticleResponse> getAllArticles(Integer page, Integer limit);
    FullArticleResponse getArticle(UUID articleId);
    void deleteArticle(UUID articleId);
    List<ArticleResponse> getAllArticlesByCreatorId(UUID creatorId, Integer page, Integer limit);
    ArticleResponse updateArticle(UpdateArticleRequest updateArticleRequest);
    ArticleResponse createArticle(CreateArticleRequest article);
}
