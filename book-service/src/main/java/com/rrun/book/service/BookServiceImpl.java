package com.rrun.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrun.book.dto.BookDto;
import com.rrun.book.entity.Book;
import com.rrun.book.exception.BookNotFoundException;
import com.rrun.book.mapper.BookMapperImpl;
import com.rrun.book.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	

	@Override
	public Book addBook(BookDto bookDto) {
		Book book = new BookMapperImpl().convert(bookDto);
		Book newbook = bookRepository.save(book);
		return newbook;
	}

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(int bookId) {
		Optional<Book> optionalbook = bookRepository.findById(bookId);
		if (!optionalbook.isPresent()) {
			throw new BookNotFoundException("book not found.");
		}
		return optionalbook.get();
	}

	@Override
	public Book updateBook(BookDto bookDto, int bookId) {
		Book updatedbook = new BookMapperImpl().convert(bookDto);
		Book existingbook = getBookById(bookId);
		existingbook.setIsActive(true);
		existingbook.setAuthor(updatedbook.getAuthor());
		existingbook.setTitle(updatedbook.getTitle());
		return bookRepository.save(existingbook);
	}

	@Override
	public Book deleteBook(int bookId) {
		Book book = getBookById(bookId);
		bookRepository.deleteById(bookId);
		return book;
	}

	@Override
	public Book getBooksByName(String name) {
		Book book = bookRepository.findByTitle(name);
		if (book != null) {
			return book;
			
		}else {
			throw new BookNotFoundException("book not found.");
		}
		
	}

}
