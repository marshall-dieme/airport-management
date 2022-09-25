package com.saraya.parking.services;

import java.util.List;

import com.saraya.parking.dto.RenaltsDTO;

public interface RenaltsServices {
	RenaltsDTO create(RenaltsDTO dto);
	List<RenaltsDTO> getAllRenaltes();
	RenaltsDTO getRenalts(Long id);
	RenaltsDTO update(RenaltsDTO dto, Long id);
	void delete(Long id);
}
