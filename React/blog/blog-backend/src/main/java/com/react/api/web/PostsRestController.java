package com.react.api.web;

import com.react.api.domain.Post;
import com.react.api.dto.PostPatchRequestDto;
import com.react.api.repository.PostsRepository;
import com.react.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostsRestController {

    private final PostsRepository postsRepository;
    private final PostService postService;

    @PostMapping("/posts")
    public Post savePost(@RequestBody Post posts) {
        return postsRepository.save(posts);
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable(value = "id") Long id) {
        return postsRepository.findById(id).orElse(null);
    }

    @GetMapping("/posts")
    public Page<Post> getPostList(@RequestParam(required = false) String tag, @PageableDefault Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

    /**
     * Patch post post.
     *
     * @param id                  the id
     * @param postPatchRequestDto the post patch request dto
     * @return the post
     */
    @PatchMapping("/posts/{id}")
    public Post patchPost(@PathVariable(value = "id") Long id, @RequestBody PostPatchRequestDto postPatchRequestDto) {
        Post newPost = null;
        try {
            newPost = postService.updatePostById(id, postPatchRequestDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newPost;
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") Long id) {
        try {
            postsRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
