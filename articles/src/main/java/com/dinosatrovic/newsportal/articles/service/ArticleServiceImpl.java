package com.dinosatrovic.newsportal.articles.service;

import com.dinosatrovic.newsportal.articles.config.MSRequestContext;
import com.dinosatrovic.newsportal.articles.db.ArticleRepository;
import com.dinosatrovic.newsportal.articles.db.models.ArticleEntity;
import com.dinosatrovic.newsportal.articles.exceptions.ServiceException;
import com.dinosatrovic.newsportal.articles.exceptions.ServiceExceptionEnum;
import com.dinosatrovic.newsportal.articles.resource.models.ArticleResponse;
import com.dinosatrovic.newsportal.articles.resource.models.FullArticleResponse;
import com.dinosatrovic.newsportal.articles.resource.models.UpdateArticleRequest;
import com.dinosatrovic.newsportal.articles.resource.models.CreateArticleRequest;
import com.dinosatrovic.newsportal.articles.service.connector.UsersConnector;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ObjectMapper objectMapper;
    private final MSRequestContext MSRequestContext;
    private final UsersConnector usersConnector;

    @Override
    public List<ArticleResponse> getAllArticles(Integer page, Integer limit) {
        Page<ArticleEntity> articles = articleRepository.findAll(PageRequest.of(page, limit));
        List<ArticleEntity> articlesList = articles.getContent();
        return objectMapper.convertValue(articlesList, new TypeReference<List<ArticleResponse>>(){});
    }

    @Override
    public FullArticleResponse getArticle(UUID articleId) {
        ArticleEntity articleEntity = articleRepository.findById(articleId)
                .orElseThrow(() -> new ServiceException(ServiceExceptionEnum.ARTICLE_NOT_FOUND));
        FullArticleResponse response = objectMapper.convertValue(articleEntity, FullArticleResponse.class);
        response.setCreatedByUser(usersConnector.getUser(articleEntity.getCreatedBy()));
        response.setEditedByUser(usersConnector.getUser(articleEntity.getEditedBy()));
        return response;
    }

    @Override
    public void deleteArticle(UUID articleId) {
        try {
            ArticleEntity articleEntity = articleRepository.getOne(articleId);
            articleRepository.delete(articleEntity);
        }
        catch (EntityNotFoundException | IllegalArgumentException e) {
                throw new ServiceException(ServiceExceptionEnum.ARTICLE_NOT_FOUND);
        }
    }

    @Override
    public List<ArticleResponse> getAllArticlesByCreatorId(UUID creatorId, Integer page, Integer limit) {
        List<ArticleEntity> articlesList = articleRepository.findAllByCreatedBy(creatorId, PageRequest.of(page, limit));
        return objectMapper.convertValue(articlesList, new TypeReference<List<ArticleResponse>>(){});
    }

    @Override
    public ArticleResponse createArticle(CreateArticleRequest article) {
        ArticleEntity articleEntity = objectMapper.convertValue(article, ArticleEntity.class);
        articleEntity.setCreatedBy(MSRequestContext.getUserId());
        articleEntity.setEditedBy(MSRequestContext.getUserId());
        ArticleEntity createdArticle = articleRepository.save(articleEntity);
        return objectMapper.convertValue(createdArticle, ArticleResponse.class);
    }

    @Override
    public ArticleResponse updateArticle(UpdateArticleRequest updateArticleRequest) {
        try {
            ArticleEntity articleEntity = articleRepository.getOne(updateArticleRequest.getId());
            if(updateArticleRequest.getContent() != null) articleEntity.setContent(updateArticleRequest.getContent());
            if(updateArticleRequest.getTitle() != null) articleEntity.setTitle(updateArticleRequest.getTitle());
            ArticleEntity createdArticle = articleRepository.save(articleEntity);
            return objectMapper.convertValue(createdArticle, ArticleResponse.class);
        }
        catch (EntityNotFoundException | IllegalArgumentException e) {
            throw new ServiceException(ServiceExceptionEnum.ARTICLE_NOT_FOUND);
        }
    }
}
