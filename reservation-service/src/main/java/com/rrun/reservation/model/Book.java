package com.rrun.reservation.model;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

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
