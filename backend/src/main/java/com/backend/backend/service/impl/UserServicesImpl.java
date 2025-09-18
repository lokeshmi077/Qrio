package com.backend.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.User;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.service.UserService;

@Service
public class UserServicesImpl implements UserService {
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user){

        user.setPassword1(user.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

}
