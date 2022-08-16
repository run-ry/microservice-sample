package com.rrun.reservation.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
	
	private int id;
	private Boolean status;
	private Profile profile;
	private String userName;
	private String password;
}
