package com.codewithdean.blog.blogapp.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public interface configure {
    void configure(AuthenticationManagerBuilder auth) throws Exception;
}
