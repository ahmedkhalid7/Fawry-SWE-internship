package com.example.socialmediaapp.rest.config;

import com.example.socialmediaapp.rest.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {FeedController.class, CommentController.class, LikeController.class, PostController.class, UserController.class})
public class RestConfig {
}