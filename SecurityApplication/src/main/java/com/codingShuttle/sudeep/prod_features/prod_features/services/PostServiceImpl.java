package com.codingShuttle.sudeep.prod_features.prod_features.services;

import com.codingShuttle.sudeep.prod_features.prod_features.exception.ResourceNotFoundException;
import com.codingShuttle.sudeep.prod_features.prod_features.dto.PostDto;
import com.codingShuttle.sudeep.prod_features.prod_features.entities.PostEntity;
import com.codingShuttle.sudeep.prod_features.prod_features.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper){
        this.postRepository=postRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(postEntity -> modelMapper.map(postEntity,PostDto.class)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found with id:"+postId));
        return modelMapper.map(postEntity,PostDto.class);
    }

    @Override
    public PostDto updatePostById(PostDto inputPost, Long postId) {
        PostEntity existingPost = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found with id:"+postId));
        inputPost.setId(postId);
        modelMapper.map(inputPost,existingPost);
        PostEntity savedPostEntity = postRepository.save(existingPost);
        return modelMapper.map(savedPostEntity,PostDto.class);
    }

}
