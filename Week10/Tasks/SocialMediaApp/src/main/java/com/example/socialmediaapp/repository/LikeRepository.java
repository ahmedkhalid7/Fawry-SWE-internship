package com.example.socialmediaapp.repository;

import com.example.socialmediaapp.repository.entity.Like;
import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {
    boolean existsByLikerAndPost(User liker, Post post);

    void deleteLikeByLikerAndPost(User liker, Post post);
}

