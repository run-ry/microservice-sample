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

@FeignClient(name = "GUEST-SERVICE")
@LoadBalancerClient(name = "GUEST-SERVICE")
public interface GuestFeignClient {

	@GetMapping("/v1/api/users/username/{username}")
	ResponseEntity<ApiResponse<User>> getUserByUserName(@PathVariable String username);

	@PostMapping("/v1/api/users")
	public ResponseEntity<ApiResponse<User>> addUser(@RequestBody User user);
}
