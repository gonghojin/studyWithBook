package com.react.api;

import com.react.api.domain.Post;
import com.react.api.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogBackendApplication {

    @Autowired
    private PostsRepository postsRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner createPost() {
        return args -> {
            for (int i = 0; i < 10; i++) {
                String title = "title" + i;
                String body = "body" + i;
                String[] tags = {"tags" + i};
                Post post = new Post(title, body, tags);

                postsRepository.save(post);
            }

            postsRepository.findAll().forEach(System.out :: println);
        };
    }
}
