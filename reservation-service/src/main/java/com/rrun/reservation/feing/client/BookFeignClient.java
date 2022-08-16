package com.rrun.reservation.feing.client;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rrun.reservation.model.ApiResponse;
import com.rrun.reservation.model.Book;

@FeignClient (name = "BOOK-SERVICE")
@LoadBalancerClient(name = "BOOK-SERVICE")
public interface BookFeignClient {
	@GetMapping("/v1/api/books/{bookId}")
	ApiResponse<Book> getBookById(@PathVariable int bookId);
}

