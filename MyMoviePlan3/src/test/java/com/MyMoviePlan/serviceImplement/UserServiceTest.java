package com.MyMoviePlan.serviceImplement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MyMoviePlan.dto.UserDTO;
import com.MyMoviePlan.entity.User;
import com.MyMoviePlan.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void addUserTest() {
		
		UserDTO user = new UserDTO(45l, "Abc Xyz", "abc@xyz.com", "12345");
		String addedUser= userService.addUser(user);
		assertNotNull(addedUser);
		
	}
	
	@Test
	public void getAllUsersTest() {
		List list = userService.getAllUser();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void updateUserTest() {
		
		User newuser = new User();
		newuser.setId(45l);
		newuser.setName("Abc Xyz");
		newuser.setEmail("abc@xyz.com");
		newuser.setPassword("12345");
		
		UserDTO newuser2 = new UserDTO(55l, "Pqr Stu", "pqr@stu.com", "67890");
		
		String response = userService.updateUser(newuser2);
		assertEquals("User Updated Successfully",response);
	}

}
