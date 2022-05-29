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
import org.springframework.web.bind.annotation.RestController;

import com.project.learnapp.entities.User;
import com.project.learnapp.repos.UserRepository;
import com.project.learnapp.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
//	public UserController(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId,newUser);
	}
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
	
	
}
