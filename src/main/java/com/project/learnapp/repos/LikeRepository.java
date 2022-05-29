package com.project.learnapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.learnapp.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	List<Like> findByUserIdAndPostId(Long userId, Long postId);

	List<Like> findByPostId(Long postId);

	List<Like> findByUserId(Long userId);

}
