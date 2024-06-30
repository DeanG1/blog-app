package com.codewithdean.blog.blogapp.services;

import com.codewithdean.blog.blogapp.payloads.CategoryDto;
import com.codewithdean.blog.blogapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    void deleteCategory(Integer categoryId);
    CategoryDto getCategory (Integer categoryId);
    List<CategoryDto> getCategories();
}
