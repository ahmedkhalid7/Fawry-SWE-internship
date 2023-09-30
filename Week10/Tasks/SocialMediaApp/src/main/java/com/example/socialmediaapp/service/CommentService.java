package com.example.socialmediaapp.service;


import com.example.socialmediaapp.repository.entity.Comment;
import com.example.socialmediaapp.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> findCommentByPostId(int postId);

    void save(Comment comment);
}
