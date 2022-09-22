package com.saraya.services.serviceI;

import java.util.List;

import com.saraya.services.dto.ServiceDTO;

public interface Services {
 ServiceDTO createService(ServiceDTO dto);
 List<ServiceDTO> getAllServices();
 ServiceDTO showService(Long id);
 ServiceDTO updateServices(ServiceDTO dto, Long id);
 void delete(Long id);
}
