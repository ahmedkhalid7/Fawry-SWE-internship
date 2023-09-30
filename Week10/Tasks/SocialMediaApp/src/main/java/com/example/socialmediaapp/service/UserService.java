package com.example.socialmediaapp.service;

import com.example.socialmediaapp.repository.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

    boolean existsByEmailAndPassword(String email, String password);

    void save(User user);

    User findByEmail(String email);
}
