package com.rrun.user.service;

import java.util.List;

import com.rrun.user.dto.UserDto;
import com.rrun.user.entity.User;

public interface UserService {

	public User addUser(UserDto userDto);

	public List<User> getUsers();

	public User getUserById(int userId);

	public User updateUser(UserDto userDto, int userId);

	public String deleteUser(int userId);

	public User getUserByUserName(String username);

}
