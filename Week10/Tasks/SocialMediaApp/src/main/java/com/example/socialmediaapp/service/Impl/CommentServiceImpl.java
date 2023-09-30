package com.example.socialmediaapp.service.Impl;

import com.example.socialmediaapp.repository.CommentRepository;
import com.example.socialmediaapp.repository.entity.Comment;
import com.example.socialmediaapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<Comment> findCommentByPostId(int postId) {
        return commentRepository.findCommentByPostId(postId);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
