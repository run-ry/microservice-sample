package com.rrun.gateway.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.rrun.gateway.model.ApiResponse;
import com.rrun.gateway.model.LoginDetails;
import com.rrun.gateway.model.User;

public interface GatewayService {
	ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user);

	ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails);

}
