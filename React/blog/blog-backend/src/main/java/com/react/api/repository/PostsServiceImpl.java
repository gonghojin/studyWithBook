package com.react.api.repository;

import com.react.api.domain.Post;
import com.react.api.dto.PostPatchRequestDto;
import com.react.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsServiceImpl implements PostService {
    final PostsRepository postsRepository;

    @Override
    public Post updatePostById(Long id, PostPatchRequestDto postPatchRequestDto) {
        Post oldPost = postsRepository.getOne(id);
        oldPost.setTitle(postPatchRequestDto.getTitle());
        oldPost.setBody(postPatchRequestDto.getBody());
        oldPost.setTags(postPatchRequestDto.getTags());

        return oldPost;
    }
}
