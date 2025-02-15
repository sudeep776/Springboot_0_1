package com.codingShuttle.sudeep.prod_features.prod_features.controllers;

import com.codingShuttle.sudeep.prod_features.prod_features.advices.ApiResponse;
import com.codingShuttle.sudeep.prod_features.prod_features.dto.PostDto;
import com.codingShuttle.sudeep.prod_features.prod_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/posts")
//@RequiredArgsConstructor
//public class PostController {
//    private final PostService postService;
//
//    @GetMapping("/test")
//    public String test(){
//        return "change12";
//    }
//
//    @GetMapping
//    public List<PostDto> getAllPosts(){
//        return postService.getAllPosts();
//    }
//
//    @GetMapping("/{postId}")
//    public PostDto getPostById(@PathVariable Long postId){
//        return postService.getPostById(postId);
//    }
//
//    @PostMapping
//    public PostDto createNewPost(@RequestBody PostDto postDto){
//        return postService.createNewPost(postDto);
//    }
//
//    @PutMapping("/{postId}")
//    public PostDto updatePost(@RequestBody PostDto inputPost,@PathVariable Long postId){
//        return postService.updatePostById(inputPost,postId);
//    }
//}

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/test")
    public ApiResponse<String> test(){
        return new ApiResponse<>("change12");
    }

    @GetMapping
    public ApiResponse<List<PostDto>> getAllPosts(){
        List<PostDto> posts = postService.getAllPosts();
        return new ApiResponse<>(posts); // Wrap the list of posts in ApiResponse
    }

    @GetMapping("/{postId}")
    public ApiResponse<PostDto> getPostById(@PathVariable Long postId){
        PostDto post = postService.getPostById(postId);
        return new ApiResponse<>(post); // Wrap the post in ApiResponse
    }

    @PostMapping
    public ApiResponse<PostDto> createNewPost(@RequestBody PostDto postDto){
        PostDto createdPost = postService.createNewPost(postDto);
        return new ApiResponse<>(createdPost); // Wrap the created post in ApiResponse
    }

    @PutMapping("/{postId}")
    public ApiResponse<PostDto> updatePost(@RequestBody PostDto inputPost, @PathVariable Long postId){
        PostDto updatedPost = postService.updatePostById(inputPost, postId);
        return new ApiResponse<>(updatedPost); // Wrap the updated post in ApiResponse
    }
}
