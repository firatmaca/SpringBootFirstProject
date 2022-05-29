package com.project.learnapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.learnapp.Request.CommentCreateRequest;
import com.project.learnapp.Request.CommentUpdateRequest;
import com.project.learnapp.entities.Post;
import com.project.learnapp.entities.Comment;
import com.project.learnapp.entities.User;
import com.project.learnapp.repos.CommentRepository;
import com.project.learnapp.repos.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;


	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		//List<Comment> comments;
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
		}else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		}
		else {
			return commentRepository.findAll();
		}
		 
	}	

	public void deleteCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}

	public Comment getOneCommentById(Long commentId) {
		return commentRepository.getById(commentId);
	}

	public Comment createOneComment(CommentCreateRequest comment) {
		User user = userService.getOneUserById(comment.getUserId());
		Post post = postService.getOnePostById(comment.getPostId());
		if(user != null && post != null) {
			Comment savedCommend = new Comment();
			savedCommend.setId(comment.getId());
			savedCommend.setPost(post);
			savedCommend.setUser(user);
			savedCommend.setText(comment.getText());
			commentRepository.save(savedCommend);
			return savedCommend;
		}

		return null;
	}

	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest request) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment commentToUpdate = comment.get();
			commentToUpdate.setText(request.getText());
			return commentRepository.save(commentToUpdate);
		}else
			return null;
	}
}
