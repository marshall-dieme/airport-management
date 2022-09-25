package com.saraya.appli.mapper;

import org.springframework.stereotype.Component;

import com.saraya.appli.dto.ServicesDTO;
import com.saraya.appli.model.ServicesEntity;

@Component
public class convertServices {
	
	public ServicesEntity dtoTOEntity( ServicesDTO serviceDTO) {
		ServicesEntity se = new ServicesEntity();
		se.setServices_name(serviceDTO.getServices_name());
		return se;
	}
	
	
	
	public ServicesDTO EntityTOdto( ServicesEntity entity) {
		ServicesDTO sd = new ServicesDTO();
		sd.setServices_id(entity.getServices_id());
		sd.setServices_name(entity.getServices_name());
		return sd;
	}
}
