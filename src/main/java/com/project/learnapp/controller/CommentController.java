package com.project.learnapp.controller;

import java.util.List;
import java.util.Optional;

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

import com.project.learnapp.Request.CommentCreateRequest;
import com.project.learnapp.Request.CommentUpdateRequest;
import com.project.learnapp.entities.Comment;
import com.project.learnapp.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> userId, 
			@RequestParam Optional<Long> postId) {
		return commentService.getAllCommentsWithParam(userId, postId);
	}
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneCommentById(commentId);
	}
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest comment) {
		return commentService.createOneComment(comment);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
		return commentService.updateOneCommentById(commentId, request);
	}
	
	
	@DeleteMapping("/{commentId}")
	public void deleteCommentById(Long commentId) {
		commentService.deleteCommentById(commentId);
	}
}
