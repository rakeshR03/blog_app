package com.learning.blog_app.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    @Query("Select a from articles a where a.slug=?1 ")
    List<ArticleEntity> findArticleEntityBySlugContaining(String slug);

//    List<ArticleEntity> findArticleEntityBySlugContaining(String slug);
}
