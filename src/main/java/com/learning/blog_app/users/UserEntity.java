package com.learning.blog_app.users;

import com.learning.blog_app.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name="users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {
}
