package com.rrun.reservation;

import org.junit.jupiter.api.BeforeEach;
import com.rrun.reservation.dto.ReservationDto;


class ReservationApplicationTest {

	private ReservationDto reservationDto;


	@BeforeEach
	void beforeEach() {
		reservationDto = new ReservationDto();
		reservationDto.setId(1);
		reservationDto.setIsActive(true);
		reservationDto.setBookingStatus("Booked");
		String checkin = "2021-05-05";
		String checkout = "2021-05-10";
		reservationDto.setCheckInDate(checkin);
		reservationDto.setCheckOutDate(checkout);
		reservationDto.setHotelName("ABC");
		reservationDto.setPartyMix(4);
		reservationDto.setTotalCost(10000);
		reservationDto.setUserName("test");
		reservationDto.setPayment(new Payment(1, "Credit card", "Success"));
	}

	
	
}
