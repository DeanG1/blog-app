package com.codewithdean.blog.blogapp.repositories;

import com.codewithdean.blog.blogapp.enities.Category;
import com.codewithdean.blog.blogapp.enities.Post;
import com.codewithdean.blog.blogapp.enities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:title%")
    List<Post> findByTitle(@Param("title") String title);
}
