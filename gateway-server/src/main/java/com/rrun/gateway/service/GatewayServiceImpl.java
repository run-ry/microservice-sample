package com.rrun.gateway.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rrun.gateway.model.ApiResponse;
import com.rrun.gateway.model.LoginDetails;
import com.rrun.gateway.model.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GatewayServiceImpl implements GatewayService {

	@Autowired
	private RestTemplate restTemplate;

	private final String authUrl ="http://localhost:8083";

	@Override
	@CircuitBreaker(name = "guest-service", fallbackMethod = "loginFallback")
	public ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails) {
		log.info("sending the get call to the login");
		ApiResponse<String> apiResponse = restTemplate
				.postForEntity(authUrl+"/v1/api/login", loginDetails, ApiResponse.class).getBody();
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	public ResponseEntity<ApiResponse<String>> loginFallback(LoginDetails loginDetails, Exception e) {
		log.info("Entired into the loginFallback");
		return new ResponseEntity<>(new ApiResponse<>(null, new Date(), e.getMessage()),
				HttpStatus.SERVICE_UNAVAILABLE);

	}

	@Override
	public ResponseEntity<ApiResponse<User>> signUp(User userDto) {
		log.info("sending the post call to the signup");
		ApiResponse<User> apiResponse = restTemplate
				.postForEntity(authUrl+"/v1/api/signup", userDto, ApiResponse.class).getBody();
		return  new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	}

}
