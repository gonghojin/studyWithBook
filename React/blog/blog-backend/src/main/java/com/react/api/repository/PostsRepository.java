package com.react.api.repository;

import com.react.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
