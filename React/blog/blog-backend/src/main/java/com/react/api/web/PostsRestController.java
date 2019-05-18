package com.react.api.web;

import com.react.api.domain.Post;
import com.react.api.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostsRestController {

    private final PostsRepository postsRepository;

    @PostMapping("/posts")
    public Post savePost(@RequestBody Post posts) {
        return postsRepository.save(posts);
    }

}
