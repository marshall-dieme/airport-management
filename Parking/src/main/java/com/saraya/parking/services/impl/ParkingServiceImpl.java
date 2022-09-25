package com.saraya.parking.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.parking.bean.Parking;
import com.saraya.parking.dto.ParkingDTO;
import com.saraya.parking.mapper.Mapper;
import com.saraya.parking.repository.ParkingRepository;
import com.saraya.parking.services.ParkingSrevices;
@Service
public class ParkingServiceImpl implements ParkingSrevices {
	@Autowired
	private Mapper mapper;
	@Autowired
	private ParkingRepository parkingRepository;
	@Override
	public ParkingDTO createParking(ParkingDTO dto) {
		Parking parking = mapper.toParking(dto);
		parkingRepository.save(parking);
		ParkingDTO parkingDTO = mapper.toDTO(parking);
		return parkingDTO;
	}

	@Override
	public List<ParkingDTO> getAllParking() {
		List<Parking> list = parkingRepository.findAll();
		List<ParkingDTO> dtos = new ArrayList<>();
		for (Parking rentals : list) {
			ParkingDTO dto = mapper.toDTO(rentals);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public ParkingDTO getParking(Long id) {
		Optional<Parking> optional = parkingRepository.findById(id);
		ParkingDTO dto = null;
		if (optional.isPresent()) {
			dto = mapper.toDTO(optional.get());
		} else {
			throw new RuntimeException("check the id that you want to update");
		}
		return dto;
	}

	@Override
	public ParkingDTO updateParking(ParkingDTO dto, Long id) {
		Optional<Parking> optional = parkingRepository.findById(id);
		ParkingDTO parkingdto = null;
		if (optional.isPresent()) {
			Parking parking = optional.get();
			parking.setAmount(dto.getAmount());
			parking.setCar_no(dto.getCar_no());
			parking.setContact(dto.getContact());
			parking.setEmail(dto.getEmail());
			parking.setEntry_date(LocalDate.parse(dto.getEntry_date()));
			parking.setEntry_time(LocalTime.parse(dto.getEntry_time()));
			parking.setExit_date(LocalDate.parse(dto.getExit_date()));
			parking.setExit_time(LocalTime.parse(dto.getExit_time()));
			parking.setName(dto.getName());
			parkingdto = mapper.toDTO(parking);
		}
		return parkingdto;
	}

	@Override
	public void deleteParking(Long id) {
		parkingRepository.deleteById(id);
	}

	
}
