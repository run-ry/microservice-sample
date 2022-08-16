package com.rrun.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
	
	private int id;
	private Boolean isActive;
	private String userName;
	private int bookId;
	private String issuedDate;
	private String returnDate;
	private String status;

}
