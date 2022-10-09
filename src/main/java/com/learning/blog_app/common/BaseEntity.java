package com.learning.blog_app.common;

import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable = false)
    private Long Id;

    @Setter
    @CreationTimestamp
    private Date createdAt;

    @Setter
    @UpdateTimestamp
    private Date UpdatedAt;
}
