package com.codewithdean.blog.blogapp;

import com.codewithdean.blog.blogapp.config.AppConstants;
import com.codewithdean.blog.blogapp.enities.Role;
import com.codewithdean.blog.blogapp.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.passwordEncoder.encode("xyz"));
        try {
            Role role = new Role();
            role.setId(AppConstants.ADMIN_USER);
            role.setName("ADMIN_USER");

            Role role1 = new Role();
            role1.setId(AppConstants.NORMAL_USER);
            role1.setName("NORMAL_USER");

            List<Role> roles = List.of(role, role1);
            List<Role> result = this.roleRepository.saveAll(roles);
            result.forEach(r -> {
                System.out.println(r.getName());
            });
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
