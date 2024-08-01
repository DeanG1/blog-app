package com.codewithdean.blog.blogapp.repositories;

import com.codewithdean.blog.blogapp.enities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
