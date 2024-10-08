package com.codewithdean.blog.blogapp.controllers;

import com.codewithdean.blog.blogapp.payloads.ApiResponse;
import com.codewithdean.blog.blogapp.payloads.CategoryDto;
import com.codewithdean.blog.blogapp.payloads.UserDto;
import com.codewithdean.blog.blogapp.services.CategoryService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Post - create category
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }
    //Put - update category
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updateCategoryDto, HttpStatus.OK);
    }
    //Delete - delete category
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted succesfully", true), HttpStatus.OK);
    }
    //Get - get all categories
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
    //Get - get single category
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }
}
