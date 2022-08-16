package com.rrun.guest.dto;


import com.googlecode.jmapper.annotations.JMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	@JMap
	private int id;
	
	@JMap
	private Boolean status;
	
	@JMap
	private ProfileDto profile;
	
	@JMap
	private String userName;
	
	@JMap
	private String password;
}
