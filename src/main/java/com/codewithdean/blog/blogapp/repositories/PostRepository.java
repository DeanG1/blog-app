package com.codewithdean.blog.blogapp.repositories;

import com.codewithdean.blog.blogapp.enities.Category;
import com.codewithdean.blog.blogapp.enities.Post;
import com.codewithdean.blog.blogapp.enities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
