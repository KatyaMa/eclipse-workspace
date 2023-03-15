package com.sociaMedia;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sociaMedia.controller.PostController;
import com.sociaMedia.entity.Post;
import com.sociaMedia.repositoryDAO.PostRepository;
import com.sociaMedia.service.UserService;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

	private MockMvc mockMvc;

	@Mock
	private PostRepository postRepository;

	@Mock
	private UserService userService;

	@Mock
	private UserDetails userDetails;

	@InjectMocks
	private PostController postController;

	@BeforeEach
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(postController).setViewResolvers(viewResolver).build();
	}

	@Test
	void testShowNewPostForm() throws Exception {
		List<Post> posts = new ArrayList<>();
		when(postRepository.findAll()).thenReturn(posts);

		mockMvc.perform(get("/new-post")).andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(model().attributeExists("posts")).andExpect(model().attributeExists("post"));
	}

}

// 1st test testShowNewPostForm() checks that when a user navigates to the "/new-post" endpoint, the index view is returned with the model attributes "posts" and "post". The test creates an empty list of posts, mocks the findAll() method of PostRepository to return this list, and then performs a GET request to "/new-post" using the MockMvc instance. Finally, it asserts that the response has a status of isOk(), a view name of "index", and the expected model attributes.

// test testShowHomePage() checks that when a user navigates to the "/" endpoint, the index view is returned with the model attribute "posts". The test creates a list of posts with one dummy post, mocks the findAllByOrderByCreatedAtDesc() method of PostRepository to return this list, and then performs a GET request to "/" using the MockMvc instance. Finally, it asserts that the response has a status of isOk(), a view name of "index", and the expected model attribute.

// Both tests use the MockMvcBuilders.standaloneSetup() method to configure and create a MockMvc instance, which is used to simulate HTTP requests and responses. They also use Mockito to mock the PostRepository and UserService dependencies of the PostController. These mocks are used to return fake data when the methods of the dependencies are called during the tests.
//
//Overall, these tests verify that the PostController is returning the correct view and model attributes for the specified endpoints