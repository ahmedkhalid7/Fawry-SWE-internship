package com.example.socialmediaapp.rest;


import com.example.socialmediaapp.repository.entity.Comment;
import com.example.socialmediaapp.repository.entity.Post;
import com.example.socialmediaapp.repository.entity.User;
import com.example.socialmediaapp.service.CommentService;
import com.example.socialmediaapp.service.PostService;
import com.example.socialmediaapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

//    @GetMapping ("/addComment")
//    public String addComment(@RequestParam("id") int postId, Model model){
//        Post post = postService.findById(postId);
//        Comment comment = new Comment();
//        comment.setPost(post);
//        model.addAttribute("comment", comment);
//        return "addComment";
//    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam("id") int postId,
                             @RequestParam("commentContent") String content,
                             Principal principal) {
        String commenterEmail = principal.getName();
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCommenter(userService.findByEmail(commenterEmail));
        comment.setPost(postService.findById(postId));
        commentService.save(comment);

        return "redirect:/comments/view?id=" + postId;
    }

    @GetMapping("/view")
    public String viewComments(@RequestParam("id") int postId, Model model) {
        Post post = postService.findById(postId);
        List<Comment> comments = commentService.findCommentByPostId(postId);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "viewComments";
    }
}
