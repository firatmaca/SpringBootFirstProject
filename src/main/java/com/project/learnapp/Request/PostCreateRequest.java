package com.project.learnapp.Request;

import lombok.Data;

@Data
public class PostCreateRequest {
	Long Id;
	String title;
	String text; 
	Long userId;
}
