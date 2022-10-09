package com.learning.blog_app.articles;

import com.learning.blog_app.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name="articles")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity extends BaseEntity {

}
