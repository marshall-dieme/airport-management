package com.saraya.parking.services;

import java.util.List;

import com.saraya.parking.dto.ParkingDTO;


public interface ParkingSrevices {
	ParkingDTO createParking(ParkingDTO dto);
	List<ParkingDTO> getAllParking();
	ParkingDTO getParking(Long id);
	ParkingDTO updateParking(ParkingDTO dto, Long id);
	void deleteParking(Long id);
}
