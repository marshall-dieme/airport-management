package com.saraya.passengerdetails.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.passengerdetails.dto.PassengerDetailsDTo;
import com.saraya.passengerdetails.mappr.Mapper;
import com.saraya.passengerdetails.model.PassengerDetails;
import com.saraya.passengerdetails.reository.PassengerDetailsRepository;
import com.saraya.passengerdetails.services.PassengerDetailsServices;
@Service
public class ServicesImpl implements PassengerDetailsServices{
	@Autowired
	private PassengerDetailsRepository repository;
	@Autowired
	private Mapper mapper;
	@Override
	public PassengerDetailsDTo createPassnegerDetailsDTO(PassengerDetailsDTo passengerDetailsDTo) {
		PassengerDetails details = mapper.toEntity(passengerDetailsDTo);
		repository.save(details);
		PassengerDetailsDTo detailsDTo = mapper.toDto(details);
		return detailsDTo;
	}

	@Override
	public List<PassengerDetailsDTo> getAllPassengerDetails() {
		List<PassengerDetails> details = repository.findAll();
		List<PassengerDetailsDTo> detailsDTos = new ArrayList<>();
		for (PassengerDetails passengerDetails : details) {
			PassengerDetailsDTo detailsDTo = mapper.toDto(passengerDetails);
			detailsDTos.add(detailsDTo);
		}
		return detailsDTos;
	}

	@Override
	public PassengerDetailsDTo getPassengerDetails(Long id) {
		Optional<PassengerDetails> optional = repository.findById(id);
		PassengerDetailsDTo detailsDTo = null;
		if (optional.isPresent()) {
			detailsDTo = mapper.toDto(optional.get());
		} else {
			throw new RuntimeException("ID not found !!!!");
		}
		return detailsDTo;
	}

	@Override
	public PassengerDetailsDTo updatePassengerDelais(PassengerDetailsDTo detailsDTo, Long id) {
		Optional<PassengerDetails> optional = repository.findById(id);
		PassengerDetailsDTo dTo = null;
		if (optional.isPresent()) {
			PassengerDetails details = optional.get();
			details.setBirthdate(LocalDate.parse(detailsDTo.getBirthdate()));
			details.setCity(detailsDTo.getCity());
			details.setCountry(detailsDTo.getCountry());
			details.setEmail(detailsDTo.getEmail());
			details.setSex(detailsDTo.getSex());
			details.setStreet(detailsDTo.getStreet());
			details.setTelephone(detailsDTo.getTelephone());
			details.setZip(detailsDTo.getZip());
			dTo = mapper.toDto(details);
			repository.save(details);
		}
		return dTo;
	}

	@Override
	public void deletePassengerDetails(Long i) {
		repository.deleteById(i);
	}

	@Override
	public PassengerDetailsDTo FinByTelephoneAndEmail(String telephone, String email) {
		PassengerDetails details = repository.findByTelephoneAndEmail(telephone, email);
		
		return mapper.toDto(details);
	}


}
