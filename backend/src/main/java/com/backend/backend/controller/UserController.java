package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.backend.entity.User;
import com.backend.backend.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user){

        return userService.createUser(user);
    }
    
    @PostMapping("/test")
    public String testUser(){

        return "lokesh";
    }
}
