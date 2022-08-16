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
	}

	
	
}
