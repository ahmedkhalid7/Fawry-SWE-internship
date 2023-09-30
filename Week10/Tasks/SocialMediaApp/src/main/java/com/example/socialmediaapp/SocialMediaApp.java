package com.example.socialmediaapp;

import com.example.socialmediaapp.repository.config.RepositoryConfig;
import com.example.socialmediaapp.rest.config.RestConfig;
import com.example.socialmediaapp.service.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        RepositoryConfig.class,
        ServiceConfig.class,
        RestConfig.class
})

public class SocialMediaApp {
    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApp.class, args);
    }
}
