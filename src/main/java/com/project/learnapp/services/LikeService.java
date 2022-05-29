package com.project.learnapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.learnapp.Request.LikeCreateRequest;
import com.project.learnapp.entities.Like;
import com.project.learnapp.entities.Post;
import com.project.learnapp.entities.User;
import com.project.learnapp.repos.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	LikeRepository likeRepository;
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;

	public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			return likeRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return likeRepository.findByPostId(postId.get());
		}else
			return likeRepository.findAll();
	}

	public Like getOneLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
		
	}

	public Like createOneLike(LikeCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user != null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(request.getId());
			likeToSave.setPost(post);
			likeToSave.setUser(user);
			return likeRepository.save(likeToSave);
		}else		
			return null;
	}

}
