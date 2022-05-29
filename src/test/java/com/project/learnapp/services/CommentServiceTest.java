package com.project.learnapp.services;


import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.learnapp.Request.CommentCreateRequest;
import com.project.learnapp.entities.Comment;
import com.project.learnapp.entities.Post;
import com.project.learnapp.entities.User;
import com.project.learnapp.repos.CommentRepository;
import org.junit.*;

class CommentServiceTest {
	
	@Autowired
	CommentService commentService;
	
	CommentRepository commentRepository;
	UserService userService;
	PostService postService;
	
	@Before
	public void setUp() throws Exception{
		commentRepository = Mockito.mock(CommentRepository.class);
		userService = Mockito.mock(UserService.class);
		postService = Mockito.mock(PostService.class);
		
	}
	
	@Test
	public void whenCreateOneComment() {
//		CommentCreateRequest commentCreateRequest = new CommentCreateRequest();
//		commentCreateRequest.setId(Long.valueOf(55) );
//		commentCreateRequest.setPostId(Long.valueOf(55));
//		commentCreateRequest.setText("firat");
//		commentCreateRequest.setUserId(Long.valueOf(55));
//		
//		Comment savedCommend = new Comment();
//		User user = new User();
//		user.setId(Long.valueOf(66));
//		user.setPassword("qqqq");
//		user.setUserName("vvvv");
//		
//		Post savedPost = new Post();
//		savedPost.setId(Long.valueOf(55));
//		savedPost.setText("aaa");
//		savedPost.setTitle("bbbb");
//		savedPost.setUser(user);
//		
//		savedCommend.setId(Long.valueOf(11) );
//		savedCommend.setPost(savedPost);
//		savedCommend.setText("firat");
//		savedCommend.setUser(user);
//		
//		Mockito.when(commentService.getOneCommentById(Long.valueOf(55))).thenReturn(commentCreateRequest);
//		Mockito.when(commentRepository.save(savedCommend)).thenReturn(savedCommend)
	}
	

}
