package com.example.webservices.repository;


import com.example.webservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findUserByUsername(String username);
Optional<User> deleteUserByUsername(String username);
}
