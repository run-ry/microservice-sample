package com.rrun.book.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rrun.book.dto.ApiResponse;
import com.rrun.book.dto.BookDto;
import com.rrun.book.entity.Book;
import com.rrun.book.mapper.BookMapper;
import com.rrun.book.service.BookService;

@RestController
public class BookControllerImpl implements BookController {


	private static final String SUCCESS = "Success";
	@Autowired
	BookService bookService;

	@Autowired
	BookMapper bookMapper;

	@Override
	public ApiResponse<BookDto> addBook(BookDto bookDto) {
		return new ApiResponse<>(bookMapper.convert(bookService.addBook(bookDto)),
				LocalDate.now(),"book added into DB.");
	}

	@Override
	public ApiResponse<List<BookDto>> getBooks() {
		List<Book> books = bookService.getBooks();
		
		List<BookDto> bookDtos = books.stream()
				.map(book -> bookMapper.convert(book))
				.collect(Collectors.toList());
		
		return new ApiResponse<>(bookDtos,
				LocalDate.now(),SUCCESS);
	}

	@Override
	public ApiResponse<BookDto> getBookById(int bookId) {
		return new ApiResponse<>(bookMapper.convert(bookService.getBookById(bookId)),
				LocalDate.now(),SUCCESS);
	}

	@Override
	public ApiResponse<BookDto> updateBook(BookDto bookDto, int bookId) {
		return new ApiResponse<>(bookMapper.convert(bookService.updateBook(bookDto, bookId)),
				LocalDate.now(),"book details updated successfully.");
	}

	@Override
	public ApiResponse<BookDto> deleteBook(int bookId) {
		return new ApiResponse<>(bookMapper.convert(bookService.deleteBook(bookId)),
				LocalDate.now(),"book deleted successfully.");
	}

	@Override
	public ApiResponse<BookDto> getBookByName(String name) {
		return new ApiResponse<>(bookMapper.convert(bookService.getBooksByName(name)),
				LocalDate.now(),SUCCESS);
	}

}
