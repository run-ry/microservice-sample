package com.rrun.reservation.mapper;


import com.rrun.reservation.dto.ReservationDto;
import com.rrun.reservation.entity.Reservation;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

public class ReservationMapper implements Mapper{
	JMapper<Reservation,ReservationDto> jMapper;

	public ReservationMapper() {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(Reservation.class));
		
		jMapper = new JMapper<>(Reservation.class, ReservationDto.class, api);
	}

	@Override
	public Reservation convert(ReservationDto reservationDto) {
		return jMapper.getDestination(reservationDto);
	}

}
