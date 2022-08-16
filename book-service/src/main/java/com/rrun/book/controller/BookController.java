package com.rrun.book.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrun.book.dto.ApiResponse;
import com.rrun.book.dto.BookDto;

import java.util.List;

@RequestMapping("/v1/api")
public interface BookController {

	@PostMapping("/books")
	public ApiResponse<BookDto> addbook(@RequestBody BookDto bookDto);

	@GetMapping("/books")
	public ApiResponse<List<BookDto>> getbooks();

	@GetMapping("/books/{bookId}")
	public ApiResponse<BookDto> getbookById(@PathVariable int bookId);
	
	@GetMapping("/books/name/{name}")
	public ApiResponse<BookDto> getbookByName(@PathVariable String name);

	@PutMapping("/books/{bookId}")
	public  ApiResponse<BookDto> updatebook(@RequestBody BookDto bookDto, @PathVariable int bookId);

	@DeleteMapping("/books/{bookId}")
	public ApiResponse<BookDto> deletebook(@PathVariable int bookId);

}
