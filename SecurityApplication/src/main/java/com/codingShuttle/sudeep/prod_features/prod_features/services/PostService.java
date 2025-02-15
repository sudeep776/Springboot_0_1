package com.codingShuttle.sudeep.prod_features.prod_features.services;

import com.codingShuttle.sudeep.prod_features.prod_features.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();
    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);
    PostDto updatePostById(PostDto inputPost,Long postId);
}
