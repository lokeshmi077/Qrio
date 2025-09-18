package com.backend.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Username is required")
    @Column(unique = true)
    private String username;

    @Email(message="Email should be valid")
    @NotBlank(message="Email is required")
    @Column(unique = true)
    private String email;

    @Column(nullable=true)
    private String password1;

    @NotBlank(message="Password is required")
    @Size(min=6, message="Password must be at least 6 characted")
    private String password;

    @NotNull(message="Mobile no is required")
    private Long mobile;

    public Long getId(){

        return id;
    }

    public void setId(Long id){

        this.id=id;
    }

    public String getUsername(){

        return username;
    }

    public void setUsername(String username){

        this.username=username;
    }

    public String getPassword1(String password1){

        return password1;
    }
    public void setPassword1(String password1){

        this.password1=password1;
    }
    
    public String getEmail(){

        return email;
    }

    public void setEmail(String email){

        this.email=email;
    }

    public String getPassword(){

        return password;
    }

    public void setPassword(String password){

        this.password=password;
    }

    public Long getMobile(){

        return mobile;
    }

    public void setMobile(Long mobile){

        this.mobile=mobile;
    }
}
