package com.codewithdean.blog.blogapp;

import com.codewithdean.blog.blogapp.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    void contextLoads() {
    }

    public void repoTest(){
        String className = this.userRepository.getClass().getName();
        String packName = this.userRepository.getClass().getPackage().getName();
        System.out.println(className);
        System.out.println(packName);
    }
}
