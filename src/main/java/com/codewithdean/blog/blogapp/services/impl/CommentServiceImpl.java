package com.codewithdean.blog.blogapp.services.impl;

import com.codewithdean.blog.blogapp.enities.Comment;
import com.codewithdean.blog.blogapp.enities.Post;
import com.codewithdean.blog.blogapp.exceptions.ResourceNotFoundException;
import com.codewithdean.blog.blogapp.payloads.CommentDto;
import com.codewithdean.blog.blogapp.repositories.CommentRepository;
import com.codewithdean.blog.blogapp.repositories.PostRepository;
import com.codewithdean.blog.blogapp.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
        Comment comment = this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment newComment = this.commentRepository.save(comment);
        return this.modelMapper.map(newComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "commentId", commentId));
        this.commentRepository.delete(comment);
    }
}
