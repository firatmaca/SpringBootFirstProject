package com.project.learnapp.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.learnapp.Request.PostCreateRequest;
import com.project.learnapp.Request.PostUpdateRequest;
import com.project.learnapp.entities.Post;
import com.project.learnapp.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	
	@Autowired
	PostService postService;
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest postCreateRequest) {
		return postService.creteOnePost(postCreateRequest);
	}
	

	@PutMapping("/{postId}")
	public Post updateOnePost (@PathVariable Long postId, @RequestBody PostUpdateRequest updateRequest) {
		return postService.updateOnePostById(postId,updateRequest);
	}
	@DeleteMapping("/{postId}")
	public void deleteOnePost (@PathVariable Long postId) {
		  postService.deleteOnePostById(postId);
	}
}
