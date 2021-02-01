package com.dinosatrovic.newsportal.articles.db;

import com.dinosatrovic.newsportal.articles.db.models.ArticleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID>, PagingAndSortingRepository<ArticleEntity, UUID> {

    Optional<ArticleEntity> findById(UUID userId);

    List<ArticleEntity> findAllByCreatedBy(UUID createdBy, Pageable pageable);

    List<ArticleEntity> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String searchQueryTitle, String searchQueryContent);
}
