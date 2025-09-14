package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.backend.entity.User;
import com.backend.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    public User createUser(@RequestBody User user){

        return userRepository.save(user);
    }
    
}
