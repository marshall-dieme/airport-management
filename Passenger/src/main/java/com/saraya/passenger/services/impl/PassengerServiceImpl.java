package com.saraya.passenger.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saraya.passenger.dto.PassengerDTO;
import com.saraya.passenger.mapper.ConvertPassenger;
import com.saraya.passenger.model.Passengar;
import com.saraya.passenger.repository.PassengerRepository;
import com.saraya.passenger.services.PassengerServices;

@Service
public class PassengerServiceImpl implements PassengerServices {
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private ConvertPassenger convertPassenger;
	@Override
	public PassengerDTO createPassenger(PassengerDTO passengerDTO) {
		Passengar passenger = convertPassenger.toPassenger(passengerDTO);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> urlValue = new HashMap<>();
		urlValue.put("telephone", passengerDTO.getTelephone());
		urlValue.put("email", passengerDTO.getEmail());
		
		String url= "http://localhost:8300/passengerdetails/Details/{telephone}/{email}";
		
		Long passenger_details_id = restTemplate.getForEntity(url, Long.class, urlValue).getBody();
		
		passenger.setPassenger_details_id(passenger_details_id);
		
		passenger = passengerRepository.save(passenger);
		
		PassengerDTO dto = convertPassenger.toDTO(passenger);
		
		return dto;
	}

	@Override
	public List<PassengerDTO> getAllPassenger() {
		List<Passengar> details = passengerRepository.findAll();
		List<PassengerDTO> DTos = new ArrayList<>();
		for (Passengar passenger : details) {
			PassengerDTO dto = convertPassenger.toDTO(passenger);
			DTos.add(dto);
		}
		return DTos;
	}

	@Override
	public PassengerDTO getPassenger(Long passengerId) {
		Optional<Passengar> optional = passengerRepository.findById(passengerId);
		PassengerDTO DTo = null;
		if (optional.isPresent()) {
			DTo = convertPassenger.toDTO(optional.get());
		} else {
			throw new RuntimeException("ID not found !!!!");
		}
		return DTo;
	}

	@Override
	public PassengerDTO updatePassenger(PassengerDTO passengerDTO, Long PassengerId) {
		Optional<Passengar> optional = passengerRepository.findById(PassengerId);
		PassengerDTO dto = null;
		if (optional.isPresent()) {
			Passengar passenger = optional.get();
			passenger.setFirstname(passengerDTO.getFirstname());
			passenger.setLastname(passengerDTO.getLastname());
			passenger.setPassport_no(passengerDTO.getPassport_no());
			dto = convertPassenger.toDTO(passenger);
			passengerRepository.save(passenger);
		}
		return dto;
	}

	@Override
	public void deletePassenger(Long id) {
		passengerRepository.deleteById(id);
	}

}
