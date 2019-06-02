package com.react.api.service;

import com.react.api.domain.Post;
import com.react.api.dto.PostPatchRequestDto;

public interface PostService {
    Post updatePostById(Long id, PostPatchRequestDto postPatchRequestDto);
}
