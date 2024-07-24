package com.codewithdean.blog.blogapp.services;

import com.codewithdean.blog.blogapp.payloads.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
