package com.codewithdean.blog.blogapp.enities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name="title", length = 100, nullable = false)
    private String categoryTitle;
    @Column(name="description")
    private String categoryDescriptipon;
}
