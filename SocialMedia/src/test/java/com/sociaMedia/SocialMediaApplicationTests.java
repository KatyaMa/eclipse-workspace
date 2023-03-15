package com.sociaMedia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.sociaMedia.entity.Role;
import com.sociaMedia.entity.User;
import com.sociaMedia.repositoryDAO.UserRepository;
import com.sociaMedia.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class SocialMediaApplicationTests {

	private UserServiceImpl userServiceImpl;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserRepository(userRepository);
	}

	@Test
	void testGetUserById() {
		Long userId = 8L;
		User user = new User();
		user.setId(userId);

		Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		User result = userServiceImpl.getUserById(userId);
		assertNotNull(result);
		assertEquals(user.getId(), result.getId());
		Mockito.verify(userRepository, Mockito.times(1)).findById(userId);
	}

	// testing the scenario where the user is not found by the getUserById() method
	// of userServiceImpl.
	// The code is expecting that calling the userRepository.findById() method with
	// the given user ID will return an empty optional.
	@Test
	void testGetUserByIdNotFound() {
		Long userId = 1L;
		Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());
		assertThrows(RuntimeException.class, () -> userServiceImpl.getUserById(userId));
		Mockito.verify(userRepository, Mockito.times(1)).findById(userId);
	}

//
	@Test
	void testFindAll() {
		List<User> userList = Arrays.asList(new User(), new User(), new User());
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		List<User> result = userServiceImpl.findAll();
		assertEquals(userList.size(), result.size());
		Mockito.verify(userRepository, Mockito.times(1)).findAll();
	}

	@Test
	void testLoadUserByUsername() {
		String email = "machneva115@gmail.com";
		User user = new User();
		user.setEmail(email);
		user.setPassword("1234");
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));

		Mockito.when(userRepository.findByEmail(email)).thenReturn(user);
		org.springframework.security.core.userdetails.UserDetails result = userServiceImpl.loadUserByUsername(email);
		assertNotNull(result);
		assertEquals(user.getEmail(), result.getUsername());
		assertEquals(user.getPassword(), result.getPassword());
		assertEquals(user.getRoles().size(), result.getAuthorities().size());
		Mockito.verify(userRepository, Mockito.times(1)).findByEmail(email);
	}

	@Test
	void testLoadUserByUsernameNotFound() {
		String email = "doesnotExist@gmail.com";
		Mockito.when(userRepository.findByEmail(email)).thenReturn(null);
		assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.loadUserByUsername(email));
		Mockito.verify(userRepository, Mockito.times(1)).findByEmail(email);
	}

}
