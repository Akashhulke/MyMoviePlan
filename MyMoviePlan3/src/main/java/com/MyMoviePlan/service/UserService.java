package com.MyMoviePlan.service;

import java.util.List;


import com.MyMoviePlan.dto.UserDTO;
import com.MyMoviePlan.entity.User;

public interface UserService {
	
	public String addUser(UserDTO userDto);
	
	public List<User> getAllUser();
	
	public String updateUser(UserDTO userDto);
	
	public User getUserById(long id);
	
	public String deleteUser(long id);

}
