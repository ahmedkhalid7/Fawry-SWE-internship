package com.example.socialmediaapp.service.config;

import com.example.socialmediaapp.service.CommentService;
import com.example.socialmediaapp.service.LikeService;
import com.example.socialmediaapp.service.PostService;
import com.example.socialmediaapp.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses =
        {UserService.class, PostService.class, LikeService.class, CommentService.class})
public class ServiceConfig {
}