package com.learning.blog_app.users;

import com.learning.blog_app.articles.ArticleEntity;
import com.learning.blog_app.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity(name="users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    @Column( nullable = false, unique = true)
    String username;

    @Column( nullable = false)@Setter
    String password;

    @Column( nullable = false, unique = true)
    String email;

    @Nullable   @Setter
    String bio;

    @Nullable   @Setter
    String image;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<ArticleEntity> authoredArticles;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "likers")
    Set<ArticleEntity> likedArticle;

    @ManyToMany(fetch = FetchType.LAZY)
            @JoinTable(
                    name = "followers",
                    joinColumns = @JoinColumn(name = "following_id"),
                    inverseJoinColumns = @JoinColumn(name="follower_id")
            )
    Set<UserEntity> followers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "followers")
    Set<UserEntity> following;
}
