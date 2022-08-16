package com.rrun.reservation.mapper;

import com.rrun.reservation.dto.ReservationDto;
import com.rrun.reservation.entity.Reservation;

public interface Mapper {
	public Reservation convert(ReservationDto reservationDto);
}
