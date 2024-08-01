package com.codewithdean.blog.blogapp.services.impl;

import com.codewithdean.blog.blogapp.config.AppConstants;
import com.codewithdean.blog.blogapp.enities.Role;
import com.codewithdean.blog.blogapp.exceptions.*;
import com.codewithdean.blog.blogapp.enities.User;
import com.codewithdean.blog.blogapp.payloads.UserDto;
import com.codewithdean.blog.blogapp.repositories.RoleRepository;
import com.codewithdean.blog.blogapp.repositories.UserRepository;
import com.codewithdean.blog.blogapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        //encode the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        //roles
        Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();
        user.getRoles().add(role);
        User newUser = this.userRepository.save(user);
        return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        User addedUser = this.userRepository.save(user);
        return this.modelMapper.map(addedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," Id ", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepository.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        this.userRepository.delete(user);
    }
    public User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto, User.class);
//        User user=new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}

