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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController  {
    @Autowired
    private UserService userService;

    //Post - creating user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
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
    //Explanation - so we create new method for updating the selected user by id
    //To do that we pass the object(with the params) we need UserDto
    //Then in the brackets we request the content/body of the object UserDto
    //Then we get the needed attribute for updating the user
    //After that we create updateUser we call the exact function from the service and pass the object userDto and the id of the user
    //Finally we return the updated user
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
        UserDto updatedUser = this.userService.updateUser(userDto,uid);
        return ResponseEntity.ok(updatedUser);
    }

    //Delete - delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

}



