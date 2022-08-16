package com.rrun.book.dto;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookDto {
	@JMap
	private int id;
	
	@JMap
	private String description;;
	
	@JMap
	private Boolean isActive;
	
	@JMap
	private String category;

	@JMap
	private String author;

	@JMap
	private String title;
}
