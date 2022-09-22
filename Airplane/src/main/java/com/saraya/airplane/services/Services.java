package com.saraya.airplane.services;

import java.util.List;


import com.saraya.airplane.dto.AirplaneDTO;


public interface Services {
	AirplaneDTO saveAirplane(AirplaneDTO airplaneDTO);
	 List<AirplaneDTO> getAllAirplane();
	 AirplaneDTO AirlineById(Long airplaneId);
	 AirplaneDTO updateAirplane(AirplaneDTO airplaneDTO, Long id);
	 void deleteAirplane(Long id);
}
