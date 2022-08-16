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

@FeignClient(name = "USER-SERVICE")
@LoadBalancerClient(name = "USER-SERVICE")
public interface UserFeignClient {

	@GetMapping("/v1/api/users/username/{username}")
	ResponseEntity<ApiResponse<User>> getUserByUserName(@PathVariable String username);

	@PostMapping("/v1/api/users")
	ResponseEntity<ApiResponse<User>> addUser(@RequestBody User user);
}
