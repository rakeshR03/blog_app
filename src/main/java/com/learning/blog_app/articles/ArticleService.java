package com.learning.blog_app.articles;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    void getAllArticles(){
        articleRepository.findAll();
    }

    void getArticleById(Long id){
        articleRepository.findById(id);
    }

    void getArticleBySlug(String slug){
        articleRepository.findArticleEntityBySlugContaining(slug);
    }
}
