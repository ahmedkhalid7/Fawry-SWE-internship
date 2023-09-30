package com.example.socialmediaapp.service;

import com.example.socialmediaapp.repository.entity.Like;
import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.repository.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {
    void save(Like like);

    boolean existsByLikerAndPost(User liker, Post post);

    void deleteLikeByLikerAndPost(User liker, Post post);
}
