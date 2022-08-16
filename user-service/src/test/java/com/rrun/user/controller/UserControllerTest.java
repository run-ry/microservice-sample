package com.rrun.user.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.rrun.user.dto.ProfileDto;
import com.rrun.user.dto.UserDto;
import com.rrun.user.mapper.UserMapperImpl;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {

	private UserMapperImpl userMapperImpl;

	private UserDto userDto;

	@BeforeEach
	void beforeEach() {
		userMapperImpl = new UserMapperImpl();
		userDto = new UserDto();
		userDto.setStatus(true);
		userDto.setProfile(new ProfileDto());
	}
}
