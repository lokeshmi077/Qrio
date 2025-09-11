package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.entity.User;

public interface UserRepository extends JpaRepository <User, Long>{
    
}
