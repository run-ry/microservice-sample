package com.rrun.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import com.rrun.user.dto.UserDto;
import com.rrun.user.mapper.UserMapperImpl;

class UserServiceTest {

	private UserMapperImpl userMapperImpl;
	private UserDto userDto;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		userMapperImpl = new UserMapperImpl();
		userDto = new UserDto();
		userDto.setStatus(true);

	}

}
