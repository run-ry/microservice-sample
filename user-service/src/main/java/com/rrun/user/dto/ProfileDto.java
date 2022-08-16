package com.rrun.user.dto;

import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
	@JMap
	private int id;
	
	@JMap
	private String firstName;
	
	@JMap
	private String lastName;
	
	@JMap
	private String emailid;
	
	@JMap
	private String mobileNumber;
	
	@JMap
	private String street;
	
	@JMap
	private String city;
	
	@JMap
	private String state;
	
	@JMap
	private int pinCode;
	
	@JMap
	private String country;
}
