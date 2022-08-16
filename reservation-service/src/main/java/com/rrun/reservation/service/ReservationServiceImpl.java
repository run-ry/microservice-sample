package com.rrun.reservation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rrun.reservation.dto.ReservationDto;
import com.rrun.reservation.entity.Reservation;
import com.rrun.reservation.exception.ReservationNotFoundException;
import com.rrun.reservation.feing.client.GuestFeignClient;
import com.rrun.reservation.feing.client.BookFeignClient;
import com.rrun.reservation.mapper.ReservationMapper;
import com.rrun.reservation.model.ApiResponse;
import com.rrun.reservation.model.Book;
import com.rrun.reservation.model.User;
import com.rrun.reservation.repository.ReservationRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private GuestFeignClient guestFeignClient;
	@Autowired
	private BookFeignClient bookFeignClient;


	@CircuitBreaker(name = "guest-service", fallbackMethod = "addReservationFallback")
	public ResponseEntity<ApiResponse<Reservation>> addReservation(ReservationDto reservationDto) {
		log.info("Entered" + getClass().getName());
		Reservation reservation = null;
		User user = getGuestDetails(reservationDto);
		Book book = getHotelDetails(reservationDto);
		reservation = new ReservationMapper().convert(reservationDto);
		if (user != null)
			reservation.setUserId(user.getId());
		if (book != null) {
			reservation.setBookId(book.getId());
		}

		ResponseEntity<ApiResponse<Reservation>> responseEntity = new ResponseEntity<>(
				new ApiResponse<>(reservationRepository.save(reservation), new Date(), "reservation Created"),
				HttpStatus.CREATED);
		return responseEntity;
	}

	public Book getHotelDetails(ReservationDto reservationDto) {
		return bookFeignClient.getBookById(reservationDto.getBookId()).getData();
	}

	public User getGuestDetails(ReservationDto reservationDto) {
		return guestFeignClient.getUserByUserName(reservationDto.getUserName()).getBody().getData();
	}

	public ResponseEntity<ApiResponse<String>> addReservationFallback(ReservationDto reservationDto,
			Exception exception) {
		return new ResponseEntity<>(new ApiResponse<>("inzternal Server issue", new Date(), exception.getMessage()),
				HttpStatus.SERVICE_UNAVAILABLE);
	}

	public Reservation getReservationDetailsById(int reservationId) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
		if (!optionalReservation.isPresent()) {
			throw new ReservationNotFoundException("Unble to find the Reservation");
		}
		return optionalReservation.get();
	}

	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	public Reservation cancelReservation(ReservationDto reservationDto, int reservationId) {
		Reservation reservationEntity = new ReservationMapper().convert(reservationDto);
		Reservation reservation = getReservationDetailsById(reservationId);
		reservation.setStatus(reservationEntity.getStatus());
		reservation.setIsActive(reservationEntity.getIsActive());
		return reservationRepository.save(reservation);
	}

}
