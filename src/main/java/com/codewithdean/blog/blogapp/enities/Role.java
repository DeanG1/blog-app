package com.codewithdean.blog.blogapp.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    private int id;
    private String name;
}
