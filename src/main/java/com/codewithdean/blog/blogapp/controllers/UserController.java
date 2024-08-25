package com.codewithdean.blog.blogapp.controllers;

import com.codewithdean.blog.blogapp.enities.User;
import com.codewithdean.blog.blogapp.payloads.ApiResponse;
import com.codewithdean.blog.blogapp.payloads.UserDto;
import com.codewithdean.blog.blogapp.services.UserService;
import jakarta.persistence.PreUpdate;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
public class UserController  {
    @Autowired
    private UserService userService;

    //Post - creating user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createUserDto, HttpStatus.CREATED);
    }
    //Get - get all users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    //Get - get single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
    //Put - update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Validated(UserDto.Update.class) @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
        UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    //Delete - delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

}



