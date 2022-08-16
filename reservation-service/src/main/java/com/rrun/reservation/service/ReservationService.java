package com.rrun.reservation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rrun.reservation.dto.ReservationDto;
import com.rrun.reservation.entity.Reservation;
import com.rrun.reservation.exception.ReservationNotFoundException;
import com.rrun.reservation.model.ApiResponse;

public interface ReservationService {

	public ResponseEntity<ApiResponse<Reservation>> addReservation(ReservationDto reservation);

	public Reservation getReservationDetailsById(int anyInt) throws ReservationNotFoundException;

	public List<Reservation> getAllReservations();
	
	public Reservation cancelReservation(ReservationDto reservation,int anyInt);

}
