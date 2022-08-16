package com.rrun.guest.mapper;

import com.rrun.guest.dto.UserDto;
import com.rrun.guest.entity.User;

public interface UserMapper {
   public User convert(UserDto userDto);
   public UserDto convert(User user);
}