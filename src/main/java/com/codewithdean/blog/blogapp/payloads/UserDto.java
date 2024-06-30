package com.codewithdean.blog.blogapp.payloads;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min = 4, message = "Username must be atleast 4 characters!")
    private String name;
    @Email(message = "Email address is not valid")
    private String email;
    @NotEmpty
    @Size(min = 5, max = 10, message = "Password must be atleast 5 characters and not more than 10 characters")
    private String password;
    @NotEmpty
    private String about;
}
