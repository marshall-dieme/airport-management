package com.saraya.flight.services;

import java.util.List;

import com.saraya.flight.dto.FlightDTO;

public interface FlightServices {
	FlightDTO createFlight(FlightDTO flightDTO);
	List<FlightDTO> getAllFlight();
	FlightDTO getFlight(Long id);
	FlightDTO updateFlight(FlightDTO flightDTO, Long id);
	void deleteFlight(Long id);
}
