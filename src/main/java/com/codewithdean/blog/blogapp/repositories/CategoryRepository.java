package com.codewithdean.blog.blogapp.repositories;

import com.codewithdean.blog.blogapp.enities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends JpaRepository <Category,Integer> {
}
