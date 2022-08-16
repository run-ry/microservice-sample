package com.rrun.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrun.gateway.model.ApiResponse;
import com.rrun.gateway.model.LoginDetails;
import com.rrun.gateway.model.User;

@RequestMapping("/v1/api")
public interface GatewayController {
	@PostMapping("/signup")
	ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user);

	@PostMapping("/login")
	ResponseEntity<ApiResponse<String>> login(@RequestBody LoginDetails loginDetails);

}
