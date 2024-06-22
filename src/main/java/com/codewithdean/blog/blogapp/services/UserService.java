package com.codewithdean.blog.blogapp.services;

import com.codewithdean.blog.blogapp.enities.User;
import com.codewithdean.blog.blogapp.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
