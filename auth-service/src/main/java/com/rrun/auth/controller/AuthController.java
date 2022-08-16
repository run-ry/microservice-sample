package com.rrun.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrun.auth.model.ApiResponse;
import com.rrun.auth.model.LoginDetails;
import com.rrun.auth.model.User;

@RequestMapping("/v1/api")
public interface AuthController {
	@PostMapping("/signup")
	public ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user);

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginDetails loginDetails);

	@GetMapping("/validate/{token}")
	public Boolean validateToken(@PathVariable String token);
}
