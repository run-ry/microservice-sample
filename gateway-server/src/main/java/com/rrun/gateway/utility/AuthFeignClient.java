package com.rrun.gateway.utility;

import com.rrun.gateway.model.ApiResponse;
import com.rrun.gateway.model.User;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUTH-SERVICE")
@LoadBalancerClient(name = "AUTH-SERVICE")
public interface AuthFeignClient {

	@GetMapping("/validate/{token}")
	Boolean validateToken(@PathVariable String token);

	@PostMapping("/v1/api/signup")
	ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user);

}