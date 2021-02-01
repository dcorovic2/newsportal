package com.dinosatrovic.newsportal.articles.resource;

import com.dinosatrovic.newsportal.articles.resource.models.ArticleResponse;
import com.dinosatrovic.newsportal.articles.resource.models.FullArticleResponse;
import com.dinosatrovic.newsportal.articles.resource.models.UpdateArticleRequest;
import com.dinosatrovic.newsportal.articles.resource.models.CreateArticleRequest;
import com.dinosatrovic.newsportal.articles.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleResource {

    private final ArticleService articleService;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<ArticleResponse>> getUser(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "limit", required = false) Integer limit) {
        page = (page == null) ? 0 : page;
        limit = (limit == null || limit > 100) ? 100 : limit;
        return ResponseEntity.ok(articleService.getAllArticles(page, limit));
    }

    @GetMapping(value = "/{articleId}", produces = "application/json")
    public ResponseEntity<FullArticleResponse> getUser(@PathVariable UUID articleId) {
        return ResponseEntity.ok(articleService.getArticle(articleId));
    }

    @DeleteMapping(value = "/{articleId}", produces = "application/json")
    public ResponseEntity<Void> deleteArticle(@PathVariable UUID articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/creator/{creatorId}", produces = "application/json")
    public ResponseEntity<List<ArticleResponse>> getArticlesByCreatorId(
            @PathVariable UUID creatorId,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "limit", required = false) Integer limit) {
        page = (page == null) ? 0 : page;
        limit = (limit == null || limit > 100) ? 100 : limit;
        return ResponseEntity.ok(articleService.getAllArticlesByCreatorId(creatorId, page, limit));
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody CreateArticleRequest article) {
        return ResponseEntity.ok(articleService.createArticle(article));
    }

    @PatchMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ArticleResponse> updateArticle(@RequestBody UpdateArticleRequest article) {
        return ResponseEntity.ok(articleService.updateArticle(article));
    }

}
