package com.rrun.guest;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rrun.guest.dto.ProfileDto;
import com.rrun.guest.dto.UserDto;
import com.rrun.guest.entity.User;
import com.rrun.guest.mapper.UserMapperImpl;
import com.rrun.guest.repository.GuestRepository;

@SpringBootTest
class GuestRepositoryTest {

	@Autowired
	private GuestRepository guestRepository;

	private UserDto userDto;
	private UserMapperImpl userMapperImpl;

	@BeforeEach
	void beforeEach() {
		userMapperImpl = new UserMapperImpl();
		userDto = new UserDto();
		userDto.setStatus(true);
		userDto.setCreditCards(new ArrayList<>());
		userDto.setProfile(new ProfileDto());
	}

	@Test
	void validateDataSource() {
//		User user = guestRepository.save(userMapperImpl.convert(userDto));
//		Assertions.assertNotNull(user);
	}
}
