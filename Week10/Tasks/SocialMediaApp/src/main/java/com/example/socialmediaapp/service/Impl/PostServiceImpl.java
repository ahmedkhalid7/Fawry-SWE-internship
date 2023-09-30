package com.example.socialmediaapp.service.Impl;

import com.example.socialmediaapp.repository.PostRepository;
import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

//    @Override
//    public void createPost(UserModel user, PostModel post) {
//        post.setUser(user);
//        postRepository.save(postMapper.toEntity(post));
//    }
//
//    @Override
//    public void updatePost(PostModel post) {
//        postRepository.save(postMapper.toEntity(post));
//    }
//
//    @Override
//    public void deletePost(PostModel post) {
//        postRepository.delete(postMapper.toEntity(post));
//    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
//        return postRepository.findAll()
//                .stream()
//                .map(post -> postMapper.toModel(post))
//                .collect(Collectors.toList());
    }

    @Override
    public Post findById(int id) {
        return postRepository.findPostById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
