package com.rrun.book.mapper;

import org.springframework.stereotype.Component;
import com.rrun.book.dto.BookDto;
import com.rrun.book.entity.Book;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

@Component
public class BookMapperImpl implements BookMapper{

	@Override
	public Book convert(BookDto bookDto) {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(Book.class));
		JMapper<Book,BookDto> jMapper = new JMapper<>(Book.class, BookDto.class, api);
		return jMapper.getDestination(bookDto);
	}

	@Override
	public BookDto convert(Book book) {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(BookDto.class));
		JMapper<BookDto,Book> jMapper = new JMapper<>(BookDto.class, Book.class, api);
		return jMapper.getDestination(book);
	}
}
