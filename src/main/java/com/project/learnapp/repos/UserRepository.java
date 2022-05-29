package com.project.learnapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.learnapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
