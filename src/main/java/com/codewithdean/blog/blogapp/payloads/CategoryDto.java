package com.codewithdean.blog.blogapp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min = 4, max = 20)
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, max = 200)
    private String categoryDescription;
}
