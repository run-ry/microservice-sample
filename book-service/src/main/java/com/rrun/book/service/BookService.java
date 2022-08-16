package com.rrun.book.service;

import java.util.List;

import com.rrun.book.entity.Book;
import com.rrun.book.dto.BookDto;

public interface BookService {

	public Book addBook(BookDto bookDto);

	public List<Book> getBooks();

	public Book getBookById(int bookId);

	public Book updateBook(BookDto bookDto, int bookId);

	public Book deleteBook(int bookId);

	public Book getBooksByName(String name);

}
