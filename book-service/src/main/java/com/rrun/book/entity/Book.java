package com.rrun.book.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ROOM")
@Setter
@Getter
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JMap
	private int id;
	
	@Column(name = "IS_ACTIVE")
	@JMap
	private Boolean isActive;

	@Column(name = "Category")
	@JMap
	private String category;

	@Column(name = "Author")
	@JMap
	private String author;

	@Column(name = "Title")
	@JMap
	private String title;

	@Column(name = "Description")
	@JMap
	private String description;
}
