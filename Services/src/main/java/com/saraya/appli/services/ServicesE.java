package com.saraya.appli.services;

import java.util.List;

import com.saraya.appli.dto.ServicesDTO;

public interface ServicesE {
	ServicesDTO createService(ServicesDTO dto);
	 List<ServicesDTO> getAllServices();
	 ServicesDTO showService(Long id);
	 ServicesDTO updateServices(ServicesDTO dto, Long id);
	 void delete(Long id);
}
