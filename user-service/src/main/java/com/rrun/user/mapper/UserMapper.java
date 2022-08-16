package com.rrun.user.mapper;

import com.rrun.user.dto.UserDto;
import com.rrun.user.entity.User;

public interface UserMapper {
   public User convert(UserDto userDto);
   public UserDto convert(User user);
}