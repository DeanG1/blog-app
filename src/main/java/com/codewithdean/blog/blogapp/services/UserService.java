package com.codewithdean.blog.blogapp.services;

import com.codewithdean.blog.blogapp.enities.User;
import com.codewithdean.blog.blogapp.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
