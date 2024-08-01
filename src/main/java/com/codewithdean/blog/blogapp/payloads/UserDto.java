package com.codewithdean.blog.blogapp.payloads;
import com.codewithdean.blog.blogapp.enities.Role;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    private Set<RoleDto> roles = new HashSet<>();
}
