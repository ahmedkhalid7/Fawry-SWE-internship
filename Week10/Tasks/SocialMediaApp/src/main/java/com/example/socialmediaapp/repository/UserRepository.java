package com.example.socialmediaapp.repository;

import com.example.socialmediaapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    boolean existsByEmailAndPassword(String email, String password);
    Optional<User> findByEmailAndPassword (String email, String password);

    Optional<User> findByEmail(String email);
}
