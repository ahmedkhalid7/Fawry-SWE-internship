package com.example.socialmediaapp.service.Impl;

import com.example.socialmediaapp.repository.LikeRepository;
import com.example.socialmediaapp.repository.entity.Like;
import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.repository.entity.User;
import com.example.socialmediaapp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeRepository likeRepository;

    @Override
    public void save(Like like){
        likeRepository.save(like);
    }

    @Override
    public boolean existsByLikerAndPost(User liker, Post post) {
        return likeRepository.existsByLikerAndPost(liker, post);
    }

    @Override
    public void deleteLikeByLikerAndPost(User liker, Post post) {
        likeRepository.deleteLikeByLikerAndPost(liker, post);
    }
}
