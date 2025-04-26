package com.autohuolto.autohuolto.repository;

import com.autohuolto.autohuolto.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    boolean existsByUsername(String username);  // Check if the username exists
    CustomUser findByUsername(String username);  // Retrieve user by username
}
