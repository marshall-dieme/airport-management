package com.saraya.EmployeeServicesRelationshipservice.service;

import com.saraya.EmployeeServicesRelationshipservice.dto.EmployeeServicesDto;
import com.saraya.EmployeeServicesRelationshipservice.dto.EmployeeDto;
import com.saraya.EmployeeServicesRelationshipservice.dto.ServicesDto;
import com.saraya.EmployeeServicesRelationshipservice.model.EmployeeServices;
import com.saraya.EmployeeServicesRelationshipservice.repository.EmployeeServicesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class EmployeeServicesService {

    private final EmployeeServicesRepo repo;



    public void createEmpIdAndServiceId(EmployeeServicesDto dto) {
        getEmployeeIdAndServicesId(dto);
        EmployeeServices employeeServices = mapToEntity(dto);
        repo.save(employeeServices);
    }

    /*public List<EmployeeDto> getAllEmployeesInService(Long service_id) {
        List<EmployeeDto> employees = new ArrayList<>();
        for (EmployeeDto dto : employees) {
            if (dto.getEmployee_id() )
        }

    }*/



    public void getEmployeeIdAndServicesId(EmployeeServicesDto dto) {
        Map<String, Long> values = new HashMap<>();
        values.put("services_id", dto.getServices_id());
        ServicesDto servicesDto = new RestTemplate().getForEntity(
                "http://localhost:8082/services/{services_id}", ServicesDto.class, values
        ).getBody();
        EmployeeServices employeeServices = mapToEntity(dto);
        if (servicesDto != null) {
            System.out.println(servicesDto.toString());
            employeeServices.setEmp_service_id(dto.getEmp_service_id());
        }

        values.put("employee_id", dto.getEmployee_id());
        EmployeeDto employeeDto = new RestTemplate().getForEntity(
                "http://localhost:8083/employees/{employee_id}", EmployeeDto.class, values
        ).getBody();
        if (employeeDto != null) {
            System.out.println(employeeDto.toString());
            employeeServices.setEmployee_id(employeeDto.getEmployee_id());
        }
    }



    public EmployeeServices mapToEntity(EmployeeServicesDto dto) {
        EmployeeServices employeeServices = new EmployeeServices();
        employeeServices.setEmp_service_id(dto.getEmp_service_id());
        employeeServices.setEmployee_id(dto.getEmployee_id());
        employeeServices.setServices_id(dto.getServices_id());
        return employeeServices;
    }

    public EmployeeServicesDto mapToDto(EmployeeServices employeeServices) {
        EmployeeServicesDto dto = new EmployeeServicesDto();
        dto.setEmp_service_id(employeeServices.getEmp_service_id());
        dto.setServices_id(employeeServices.getServices_id());
        dto.setEmployee_id(employeeServices.getEmployee_id());
        return dto;
    }
}
