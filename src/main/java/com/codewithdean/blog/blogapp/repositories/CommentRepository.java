package com.codewithdean.blog.blogapp.repositories;

import com.codewithdean.blog.blogapp.enities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
