package com.example.socialmediaapp.service;


import com.example.socialmediaapp.repository.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> findAllPosts();

    Post findById(int id);

    void save(Post post);

}
