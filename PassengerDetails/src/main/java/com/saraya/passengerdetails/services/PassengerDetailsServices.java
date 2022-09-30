package com.saraya.passengerdetails.services;

import java.util.List;

import com.saraya.passengerdetails.dto.PassengerDetailsDTo;

public interface PassengerDetailsServices {
	PassengerDetailsDTo createPassnegerDetailsDTO(PassengerDetailsDTo passengerDetailsDTo);
	List<PassengerDetailsDTo> getAllPassengerDetails();
	PassengerDetailsDTo getPassengerDetails(Long id);
	PassengerDetailsDTo updatePassengerDelais(PassengerDetailsDTo detailsDTo, Long id);
	void deletePassengerDetails(Long id);
	PassengerDetailsDTo FinByTelephoneAndEmail(String telephone, String email);
}
