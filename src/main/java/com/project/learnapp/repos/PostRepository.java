package com.project.learnapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.learnapp.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

}
