package com.example.socialmediaapp.rest;

import com.example.socialmediaapp.repository.entity.Like;
import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.repository.entity.User;
import com.example.socialmediaapp.service.LikeService;
import com.example.socialmediaapp.service.PostService;
import com.example.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.security.Principal;

@Controller
public class LikeController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    LikeService likeService;

    @GetMapping(value = "/likes/addOrDelete")
    @Transactional
    public String addLike(@RequestParam("id") int postId, Principal principal) {
        Post post = postService.findById(postId);
        User liker = userService.findByEmail(principal.getName());
        boolean hasLiked = likeService.existsByLikerAndPost(liker, post);
        if (hasLiked) {
            likeService.deleteLikeByLikerAndPost(liker, post);
        } else {
            Like like = new Like();
            like.setLiker(liker);
            like.setPost(post);
            likeService.save(like);
        }
        return "redirect:/feed";
    }
}