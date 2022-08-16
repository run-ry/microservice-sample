package com.rrun.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrun.reservation.entity.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}

