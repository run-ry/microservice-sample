package com.rrun.reservation.feing.client;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rrun.reservation.model.ApiResponse;
import com.rrun.reservation.model.User;

@FeignClient(name = "USER-SERVICE")
@LoadBalancerClient(name = "USER-SERVICE")
public interface UserFeignClient {

	@GetMapping("/v1/api/users/username/{username}")
	ResponseEntity<ApiResponse<User>> getUserByUserName(@PathVariable String username);
}
