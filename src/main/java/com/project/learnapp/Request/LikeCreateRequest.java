package com.project.learnapp.Request;

import lombok.Data;

@Data
public class LikeCreateRequest {
	Long id;
	Long userId;
	Long postId;
}
