package com.saraya.passenger.services;

import java.util.List;

import com.saraya.passenger.dto.PassengerDTO;

public interface PassengerServices {
	PassengerDTO createPassenger(PassengerDTO passengerDTO);
	List<PassengerDTO> getAllPassenger();
	PassengerDTO getPassenger(Long passengerId);
	PassengerDTO updatePassenger(PassengerDTO passengerDTO, Long PassengerId);
	void deletePassenger(Long id);

}
