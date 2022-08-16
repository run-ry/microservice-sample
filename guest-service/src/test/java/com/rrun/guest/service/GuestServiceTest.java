package com.rrun.guest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rrun.guest.dto.CreditCardDto;
import com.rrun.guest.dto.ProfileDto;
import com.rrun.guest.dto.UserDto;
import com.rrun.guest.entity.User;
import com.rrun.guest.exception.GuestNotFoundException;
import com.rrun.guest.mapper.UserMapperImpl;
import com.rrun.guest.repository.GuestRepository;

class GuestServiceTest {

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
