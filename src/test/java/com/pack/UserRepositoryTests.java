package com.pack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pack.model.Corporate;
import com.pack.model.User;
import com.pack.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

	@Autowired
	UserRepository userRepository;

	static User user;
	static Corporate corporate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		corporate = new Corporate(1);
		user = new User(corporate, 103, "ROLE_USER", "virtusa2", "Sales", "Hyderabad", 6789054323L, "virtusa10", "F",
				true);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corporate = null;
		user = null;
	}

	@Test
	public void saveEmployeeTest() {
		User userObj = userRepository.save(user);
		Assertions.assertEquals(user.getUsername(), userObj.getUsername());
	}

	@Test
	public void findUserByUsernameTests() {
		User userObj = userRepository.findByUsername(user.getUsername());
		Assertions.assertEquals("virtusa2", userObj.getUsername());
	}

	@Test
	public void findUserById() {
		User userObj = userRepository.findById(user.getLogin_id()).get();
		Assertions.assertNotNull(userObj.getUsername());
	}

	@Test
	public void findUserByUserId() {
		User userObj = userRepository.getById(user.getLogin_id());
		Assertions.assertNotNull(userObj.getUsername());
	}

	@Test
	public void deleteUserById() {
		User userObj = userRepository.getById(user.getLogin_id());
		userObj.setActive(false);
		User userObj2 = userRepository.save(userObj);
		Assertions.assertEquals(userObj.isActive(), userObj2.isActive());
	}

}
