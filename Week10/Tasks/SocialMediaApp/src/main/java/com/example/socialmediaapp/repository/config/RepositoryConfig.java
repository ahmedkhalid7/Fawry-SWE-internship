package com.example.socialmediaapp.repository.config;

import com.example.socialmediaapp.repository.CommentRepository;
import com.example.socialmediaapp.repository.LikeRepository;
import com.example.socialmediaapp.repository.PostRepository;
import com.example.socialmediaapp.repository.UserRepository;
import com.example.socialmediaapp.repository.entity.Comment;
import com.example.socialmediaapp.repository.entity.Like;
import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.repository.entity.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {User.class, Post.class, Comment.class, Like.class})
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, PostRepository.class, CommentRepository.class, LikeRepository.class})
public class RepositoryConfig {
}
