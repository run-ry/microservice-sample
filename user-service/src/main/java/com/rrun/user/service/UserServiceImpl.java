package com.rrun.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrun.user.dto.UserDto;
import com.rrun.user.entity.User;
import com.rrun.user.exception.UserNotFoundException;
import com.rrun.user.mapper.UserMapperImpl;
import com.rrun.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(UserDto userDto) {
		return userRepository.save(new UserMapperImpl().convert(userDto));
	}

	public List<User> getUsers() {
		return userRepository.findByStatus(true);
	}

	public User getUserById(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("Unble to find the User");
		}
		return optionalUser.get();
	}

	public User updateUser(UserDto userDto, int userId) {
		User userEntiry = new UserMapperImpl().convert(userDto);
		User user = getUserById(userId);
		user.setProfile(userEntiry.getProfile());
		user.setStatus(userEntiry.getStatus());

		return userRepository.save(user);
	}

	public String deleteUser(int userId) {// return deleted/updated User
		userRepository.deleteById(userId);
		return "User" + userId + "has updated";
	}

	@Override
	public User getUserByUserName(String username) {
		Optional<User> optionalUser = userRepository.findByUserName(username);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("Unble to find the User");
		}
		return optionalUser.get();
	}

}
