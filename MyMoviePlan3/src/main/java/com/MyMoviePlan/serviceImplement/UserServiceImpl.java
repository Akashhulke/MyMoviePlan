package com.MyMoviePlan.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyMoviePlan.dto.UserDTO;
import com.MyMoviePlan.entity.User;
import com.MyMoviePlan.repository.UserRepository;
import com.MyMoviePlan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String addUser(UserDTO userDto) {

		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
		return "New User Registered";
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public String updateUser(UserDTO userDto) {
		
		User userToUpdate = new User();
		userToUpdate.setId(userDto.getId());
		userToUpdate.setEmail(userDto.getEmail());
		userToUpdate.setName(userDto.getName());
		userToUpdate.setPassword(userDto.getPassword());

		userRepository.save(userToUpdate);

		return "User Updated Successfully";
	}

	@Override
	public User getUserById(long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public String deleteUser(long id) {
		
		userRepository.deleteById(id);
		return "User deleted";
	}

}
