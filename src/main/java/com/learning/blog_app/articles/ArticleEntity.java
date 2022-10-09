package com.learning.blog_app.articles;

import com.learning.blog_app.comments.CommentEntity;
import com.learning.blog_app.common.BaseEntity;
import com.learning.blog_app.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name="articles")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity extends BaseEntity {
    @Column(nullable = false, length = 100)
    String title;

    @Column(nullable = false, unique = true, length = 100)
    String slug;

    @Column(length = 150)
    String subtitle;

    @Column(columnDefinition = "TEXT")
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    UserEntity author;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "likes",
                    joinColumns = @JoinColumn(name="article_id"),
                    inverseJoinColumns = @JoinColumn(name="user_id")
            )
    Set<UserEntity> likers;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    Set<CommentEntity> comments;
}
