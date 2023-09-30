package com.example.socialmediaapp.rest;


import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.repository.entity.User;
import com.example.socialmediaapp.service.PostService;
import com.example.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping("/writePost")
    public String writePost(Model model) {
        model.addAttribute("post", new Post());
        return "writePost";
    }

    @PostMapping("/writePost")
    public String writePost(@ModelAttribute Post post, Principal principal, Model model) {
        User author = userService.findByEmail(principal.getName());
        post.setAuthor(author);
        postService.save(post);
        return "redirect:/feed";
    }

    @GetMapping("/editPost")
    public String editPost(@RequestParam("id") int postId, Model model) {
        Post post = postService.findById(postId);
        model.addAttribute("post", post);
        return "editPost";
    }

    @PostMapping("/editPost")
    public String editPost(@ModelAttribute("post") Post post) {
        Post existingPost = postService.findById(post.getId());
        existingPost.setContent(post.getContent());
        postService.save(existingPost);
        return "redirect:/feed";
    }
}