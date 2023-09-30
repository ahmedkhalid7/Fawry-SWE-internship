package com.example.socialmediaapp.rest;

import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private PostService postService;

    @GetMapping("/feed")
    public String showFeed(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "feed";
    }
}
