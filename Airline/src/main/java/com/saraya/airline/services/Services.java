package com.saraya.airline.services;

import java.util.List;

import com.saraya.airline.dto.AirlineDTO;

public interface Services {
 AirlineDTO saveAirline(AirlineDTO airlineDTO);
 List<AirlineDTO> getAllAirline();
 AirlineDTO AirlineById(Long airlineId);
 AirlineDTO updateAirline(AirlineDTO airlineDTO, Long id);
 void deleteAirline(Long id);
}
