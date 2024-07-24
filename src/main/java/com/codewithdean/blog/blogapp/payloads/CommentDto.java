package com.codewithdean.blog.blogapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Integer commentId;
    private String content;

}
