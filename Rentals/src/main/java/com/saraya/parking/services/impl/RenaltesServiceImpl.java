package com.saraya.parking.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.parking.dto.RenaltsDTO;
import com.saraya.parking.mapper.ConvertRentals;
import com.saraya.parking.model.Rentals;
import com.saraya.parking.repository.RenaltesRepository;
import com.saraya.parking.services.RenaltsServices;
@Service
public class RenaltesServiceImpl implements RenaltsServices {
	@Autowired
	private RenaltesRepository renaltesRepository;
	@Autowired
	private ConvertRentals convertRentals;
	@Override
	public RenaltsDTO create(RenaltsDTO dto) {
		Rentals rentals = convertRentals.toRentals(dto);
		renaltesRepository.save(rentals);
		RenaltsDTO renaltsDTO = convertRentals.toDTO(rentals);
		return renaltsDTO;
	}

	@Override
	public List<RenaltsDTO> getAllRenaltes() {
		List<Rentals> list = renaltesRepository.findAll();
		List<RenaltsDTO> dtos = new ArrayList<>();
		for (Rentals rentals : list) {
			RenaltsDTO dto = convertRentals.toDTO(rentals);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public RenaltsDTO getRenalts(Long id) {
		Optional<Rentals> optional = renaltesRepository.findById(id);
		RenaltsDTO dto = null;
		if (optional.isPresent()) {
			dto = convertRentals.toDTO(optional.get());
		} else {
			throw new RuntimeException("check the id that you want to update");
		}
		return dto;
	}

	@Override
	public RenaltsDTO update(RenaltsDTO dto, Long id) {
		Optional<Rentals> optional = renaltesRepository.findById(id);
		RenaltsDTO renaltsDTO = null;
		if (optional.isPresent()) {
			Rentals rentals = optional.get();
			rentals.setAmount(dto.getAmount());
			rentals.setCar_no(dto.getCar_no());
			rentals.setContact(dto.getContact());
			rentals.setEmail(dto.getEmail());
			rentals.setLicence_no(dto.getLicence_no());
			rentals.setName(dto.getName());
			rentals.setPickup_date(LocalDate.parse(dto.getPickup_date()));
			rentals.setPickup_time(LocalTime.parse(dto.getPickup_time()));
			rentals.setReturn_date(LocalDate.parse(dto.getReturn_date()));
			rentals.setReturn_time(LocalTime.parse(dto.getReturn_time()));
			renaltsDTO = convertRentals.toDTO(rentals);
			renaltesRepository.save(rentals);
		}
		return renaltsDTO;
	}

	@Override
	public void delete(Long id) {
		renaltesRepository.deleteById(id);
	}

}
