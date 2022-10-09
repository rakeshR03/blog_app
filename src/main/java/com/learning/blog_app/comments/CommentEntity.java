package com.learning.blog_app.comments;

import com.learning.blog_app.articles.ArticleEntity;
import com.learning.blog_app.common.BaseEntity;
import com.learning.blog_app.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "comments")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity extends BaseEntity {
    @Column(nullable = false, length = 100)
    String title;

    @Column(columnDefinition = "TEXT")
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    UserEntity author;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    ArticleEntity article;
}
