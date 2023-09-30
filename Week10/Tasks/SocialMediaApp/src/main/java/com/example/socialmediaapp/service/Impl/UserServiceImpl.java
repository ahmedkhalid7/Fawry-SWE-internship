package com.example.socialmediaapp.service.Impl;


import com.example.socialmediaapp.repository.UserRepository;
import com.example.socialmediaapp.repository.entity.User;
import com.example.socialmediaapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    

//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        return userMapper.toModel(userRepository.findByEmailAndPassword(email, password).orElse(null));
//    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseGet(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
