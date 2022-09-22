package com.saraya.services.convert;

import org.springframework.stereotype.Component;

import com.saraya.services.dto.ServiceDTO;
import com.saraya.services.model.ServiceEntity;
@Component
public class ConvertServices {
	public ServiceEntity dtoTOEntity( ServiceDTO serviceDTO) {
		ServiceEntity se = new ServiceEntity();
		se.setServices_name(serviceDTO.getServices_name());
		return se;
	}
	
	
	
	public ServiceDTO EntityTOdto( ServiceEntity entity) {
		ServiceDTO sd = new ServiceDTO();
		sd.setServices_id(entity.getServices_id());
		sd.setServices_name(entity.getServices_name());
		return sd;
	}
}
