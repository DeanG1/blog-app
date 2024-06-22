package com.codewithdean.blog.blogapp.repositories;

import com.codewithdean.blog.blogapp.enities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {

}
