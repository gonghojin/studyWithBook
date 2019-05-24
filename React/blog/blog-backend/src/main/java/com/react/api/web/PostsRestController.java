package com.react.api.web;

import com.react.api.domain.Post;
import com.react.api.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable(value = "id") Long id) {
        return postsRepository.findById(id).orElse(null);
    }

    @GetMapping("/posts")
    public Page<Post> getPostList(@RequestParam(required = false) String tag, Pageable pageable) {
        return postsRepository.findAll(pageable);
    }
}
