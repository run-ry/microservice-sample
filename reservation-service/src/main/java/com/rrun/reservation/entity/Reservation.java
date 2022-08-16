package com.rrun.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RESERVATION_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "BOOK_ID")
	private int bookId;

	@JMap
	@Column(name = "ISSUED_DATE")
	private String issuedDate;


	@JMap
	@Column(name = "RETURN_DATE")
	private String returnDate;

	
	@JMap
	@Column(name = "STATUS")
	private String status;

	@JMap
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
