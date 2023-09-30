package com.example.socialmediaapp.rest;


import com.example.socialmediaapp.repository.entity.User;
import com.example.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class UserController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @Autowired
    UserService userService;

    @GetMapping
    public String showHomePage(Model model) {
        return "home";
    }

    @GetMapping("/sign-in")
    public String SigninPage(Model model){
        model.addAttribute("loginUser", new User());
        return "signin";
    }

    @PostMapping("/sign-in")
    public String SigninPage(@Valid @ModelAttribute("loginUser") User user, BindingResult bindingResult, Model model) {

        if (user.getEmail().isEmpty()){
            bindingResult.rejectValue("email", null, "User email cannot be empty.");
        }

        if (user.getPassword().isEmpty()){
            bindingResult.rejectValue("password", null, "User password cannot be empty.");
        }

        else if (!userService.existsByEmailAndPassword(user.getEmail(), user.getPassword())){
            bindingResult.rejectValue("email", null, "user with given credentials does not exists.");
            bindingResult.rejectValue("password", null, "user with given credentials does not exists.");
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("loginUser", user);
            return "signin";
        }

        UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/feed";
    }

    @GetMapping("/sign-up")
    public String SignUp(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (user.getFirstName().isEmpty()){
            bindingResult.rejectValue("firstName", null, "First name cannot be empty.");
        }
        if (user.getFirstName().isEmpty()){
            bindingResult.rejectValue("lastName", null, "Last name cannot be empty.");
        }

        if (user.getUserName().isEmpty()){
            bindingResult.rejectValue("userName", null, "User name cannot be empty.");
        }

        if (user.getEmail().isEmpty()){
            bindingResult.rejectValue("email", null, "User email cannot be empty.");
        }

        if (user.getPassword().isEmpty()){
            bindingResult.rejectValue("password", null, "User password cannot be empty.");
        }

        if(userService.existsByEmail(user.getEmail())){
            bindingResult.rejectValue("email", null,
                    "There is already an account registered with the same email.");
        }

        if(userService.existsByUserName(user.getUserName())){
            bindingResult.rejectValue("userName", null,
                    "User name is already taken by another user. Try another one!");
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("bindingResult", bindingResult);
            return "signup";
        }

        userService.save(user);

        UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/feed";
    }

    @GetMapping("/sign-out")
    public String SignOut() {
        return "redirect:/signin";
    }

    @GetMapping("/profile")
    public String showUserProfile(Principal principal, Model model) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "userProfile";
    }

    @PostMapping("/profile")
    public String updateUserInfo(@ModelAttribute User user, Principal principal) {
        User existingUser = userService.findByEmail(principal.getName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUserName(user.getUserName());
        if (!existingUser.getEmail().equals(user.getEmail()) || !existingUser.getPassword().equals(user.getPassword())) {
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            userService.save(existingUser);
            return "redirect:/users/sign-out";
        }
        userService.save(existingUser);
        return "redirect:/users/profile";
    }
}