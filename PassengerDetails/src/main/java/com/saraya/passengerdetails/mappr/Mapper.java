package com.saraya.passengerdetails.mappr;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.saraya.passengerdetails.dto.PassengerDetailsDTo;
import com.saraya.passengerdetails.model.PassengerDetails;

@Component
public class Mapper {
	public PassengerDetails toEntity(PassengerDetailsDTo passengerDetailsDTo) {
		PassengerDetails details = new PassengerDetails();
		details.setBirthdate(LocalDate.parse(passengerDetailsDTo.getBirthdate()));
		details.setCity(passengerDetailsDTo.getCity());
		details.setCountry(passengerDetailsDTo.getCountry());
		details.setEmail(passengerDetailsDTo.getEmail());
		details.setSex(passengerDetailsDTo.getSex());
		details.setStreet(passengerDetailsDTo.getStreet());
		details.setTelephone(passengerDetailsDTo.getTelephone());
		details.setZip(passengerDetailsDTo.getZip());
		return details;
	}
	
	
	
	
	public PassengerDetailsDTo toDto(PassengerDetails passengerDetails) {
		PassengerDetailsDTo detailsDTO = new PassengerDetailsDTo();
		detailsDTO.setPassenger_details_id(passengerDetails.getPassenger_details_id());
		detailsDTO.setBirthdate(passengerDetails.getBirthdate().toString());
		detailsDTO.setCity(passengerDetails.getCity());
		detailsDTO.setCountry(passengerDetails.getCountry());
		detailsDTO.setEmail(passengerDetails.getEmail());
		detailsDTO.setSex(passengerDetails.getSex());
		detailsDTO.setStreet(passengerDetails.getStreet());
		detailsDTO.setTelephone(passengerDetails.getTelephone());
		detailsDTO.setZip(passengerDetails.getZip());
		return detailsDTO;
	}
}
