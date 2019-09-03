
package com.mskcc.chat.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mskcc.chat.demo.daoImpl.UserDaoImpl;
import com.mskcc.chat.demo.model.User;
import com.mskcc.chat.demo.repository.UserRepository;

/**
 * The ChatApplicationTests program basic unit test cases using mockito
 * 
 *
 * @author Smitha Chap
 * @version 1.0
 * @since 2019-09-02
 *
 **/

@RunWith(MockitoJUnitRunner.class)
public class ChatApplicationTests {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(ChatApplicationTests.class);
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserDaoImpl userDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindByUserame() {
		User user = new User("TTom", "Tom", "Tumbler", "Tom.Tumbler@gmail.com", "123456");
		when(userRepository.findByusername("wilma")).thenReturn(user);
		User result = userDao.findByusername("wilma");
		assertEquals("TTom", result.getUsername());
		assertEquals("Tom", result.getFirstName());
		assertEquals("Tumbler", result.getLastName());
		assertEquals("Tom.Tumbler@gmail.com", result.getEmail());
		assertEquals("123456", result.getPassword());
		if (user.getUsername().equalsIgnoreCase(result.getUsername())) {
			logger.info("user Exists");
		}

	}

	@Test
	public void testSaveNewuser() {
		User user = new User("HSober", "Hary", "Sobers", "Hari.sobers@yahoo.com", "123456");
		when(userRepository.save(user)).thenReturn(user);
		User result = userDao.saveUser(user);
		assertEquals("HSober", result.getUsername());
		assertEquals("Hary", result.getFirstName());
		assertEquals("Sobers", result.getLastName());
		assertEquals("Hari.sobers@yahoo.com", result.getEmail());
		assertEquals("123456", result.getPassword());
	}

}
