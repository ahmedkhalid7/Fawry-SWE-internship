package com.example.socialmediaapp.repository;

import com.example.socialmediaapp.repository.entity.Comment;
import com.example.socialmediaapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentByPostId(int postId);

//
//    Comment findCommentById(Long CommentId);
//
//    List<Comment> findCommentByUserName(String username);
//
//    void deleteCommentById(Long commentId);
//    void deleteAllByPost (Post post);
}
