package com.saraya.employee.service;

import com.saraya.employee.dto.EmployeeDto;
import com.saraya.employee.mapper.EmployeeMapper;
import com.saraya.employee.model.Employee;
import com.saraya.employee.repository.EmployeeRepository;
import com.saraya.employee.vo.ModelService;
import com.saraya.employee.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeMapper mapper;

    public EmployeeDto save(EmployeeDto employeeDto){
        return mapper.toDto(repository.save(mapper.toEntity(employeeDto)));
    }

    public List<EmployeeDto> findAll(){
        return mapper.toDto(repository.findAll());
    }
//
//    public EmployeeDto findById(long id){
//        Employee employee = repository.findById(id);
//        return employee != null ? mapper.toDto(employee) : null;
//    }
    public ResponseTemplateVo getEmployeeWithService(long employee_id){
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Employee employee =  repository.findById(employee_id);

        ModelService modelService = restTemplate.getForObject("http://localhost:8083/employees/" +
                employee.getService_id(), ModelService.class );
        vo.setModelService(modelService);
        vo.setEmployee(employee);
        return vo;
    }

    public EmployeeDto update(EmployeeDto employeeDto){
        return mapper.toDto(repository.save(mapper.toEntity(employeeDto)));
    }
    

    public void deleteById(long employee_id){
        repository.deleteById(employee_id);
    }
}
