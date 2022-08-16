package com.rrun.book.mapper;

import com.rrun.book.dto.BookDto;
import com.rrun.book.entity.Book;

public interface BookMapper {
	
   public Book convert(BookDto userDto);
   
   public BookDto convert(Book book);
   
}