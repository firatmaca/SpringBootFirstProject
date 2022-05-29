package com.project.learnapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.learnapp.Request.PostCreateRequest;
import com.project.learnapp.Request.PostUpdateRequest;
import com.project.learnapp.entities.Post;
import com.project.learnapp.entities.User;
import com.project.learnapp.repos.PostRepository;

@Service 
public class PostService {

	@Autowired
	PostRepository postRepository;
	@Autowired 
	UserService userService;

	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent()) {
			return postRepository.findByUserId(userId.get());
		}
		return postRepository.findAll();
	}

	public Post getOnePostById(Long postId) {
		return postRepository.getById(postId);
	}

	public Post creteOnePost(PostCreateRequest postCreateRequest) {
		User user = userService.getOneUserById(postCreateRequest.getId());
		if(user == null) {
			return null;
		}
		Post savedPost = new Post();
		savedPost.setId(postCreateRequest.getId());
		savedPost.setText(postCreateRequest.getText());
		savedPost.setTitle(postCreateRequest.getTitle());
		savedPost.setUser(user);
		return postRepository.save(savedPost);
	}

	public Post updateOnePostById(Long postId,PostUpdateRequest updateRequest) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post foundPost = post.get();
			foundPost.setText(updateRequest.getText());
			foundPost.setTitle(updateRequest.getTitle());
			postRepository.save(foundPost);
			return foundPost;
		}
		else 
			return null;
		
	}

	public void deleteOnePostById(Long postId) {
			postRepository.deleteById(postId);
	
	}
	
	
	
}
