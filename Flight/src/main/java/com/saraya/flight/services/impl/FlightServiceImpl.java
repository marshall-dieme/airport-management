package com.saraya.flight.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saraya.flight.bean.Flight;
import com.saraya.flight.dto.FlightDTO;
import com.saraya.flight.mapper.ConvertFlight;
import com.saraya.flight.repository.FlightRepository;
import com.saraya.flight.services.FlightServices;
@Service
public class FlightServiceImpl implements FlightServices {
	@Autowired
	private ConvertFlight convertFlight;
	@Autowired FlightRepository flightRepository;
	@Override
	public FlightDTO createFlight(FlightDTO flightDTO) {
		Flight flight = convertFlight.toFlight(flightDTO);
		flightRepository.save(flight);
		return flightDTO;
	}

	@Override
	public List<FlightDTO> getAllFlight() {
		List<Flight> flights = flightRepository.findAll();
		List<FlightDTO> dtos = new ArrayList<>();
		for (Flight flight : flights) {
			FlightDTO dto = convertFlight.toDTO(flight);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public FlightDTO getFlight(Long id) {
		Optional<Flight> optional = flightRepository.findById(id);
		FlightDTO flightDTO = null;
		if(optional.isPresent()) {
			Flight flight = optional.get();
			flightDTO = convertFlight.toDTO(flight);
		}
		else {
			throw new RuntimeException("the id don't exist check again!!!!!!!!!!!!!!!!!!!!");
		}
		return flightDTO;
	}

	@Override
	public FlightDTO updateFlight(FlightDTO dto, Long id) {
		Optional<Flight> optional = flightRepository.findById(id);
		FlightDTO flightDTO = null;
		if(optional.isPresent()) {
			Flight flight = optional.get();
			flight.setArrival_date(LocalDate.parse(dto.getArrival_date()));
			flight.setDeparture_date(LocalDate.parse(dto.getDeparture_date()));
			flight.setFlight_no(dto.getFlight_no());
			flight.setFrom(dto.getFrom());
			flight.setTo(dto.getTo());
			flightDTO = convertFlight.toDTO(flight);
		}

		return flightDTO;
	}

	@Override
	public void deleteFlight(Long id) {
		flightRepository.deleteById(id);
	}

}
