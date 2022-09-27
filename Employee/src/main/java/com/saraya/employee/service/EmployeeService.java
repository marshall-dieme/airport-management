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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeMapper mapper;

    public EmployeeDto save(EmployeeDto employeeDto){
        Employee employee = mapper.toEntity(employeeDto);
        employee = repository.save(employee);
        return mapper.toDto(employee);
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }
    public EmployeeDto getEmployeeById(long employee_id){
        Employee employee = repository.findById(employee_id);
        return mapper.toDto(employee);
    }
//
//    public EmployeeDto findById(long id){
//        Employee employee = repository.findById(id);
//        return employee != null ? mapper.toDto(employee) : null;
//    }
//    public ResponseTemplateVo getEmployeeWithService(long employee_id){
//        ResponseTemplateVo vo = new ResponseTemplateVo();
//        Employee employee =  repository.findById(employee_id);
//
//        ModelService modelService = restTemplate.getForObject("http://localhost:8083/employees/" +
//                employee.getService_id(), ModelService.class );
//        vo.setModelService(modelService);
//        vo.setEmployee(employee);
//        return vo;
//    }

    public EmployeeDto update(EmployeeDto employeeDto, long service_id){
        EmployeeDto employeeDto1 = getEmployeeById(service_id);
        Employee employee = mapper.toEntity(employeeDto1);
        employee.setFirstname(employeeDto.getFirstname());
        employee.setLastname(employeeDto.getLastname());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        employee.setBirthdate(LocalDate.parse(employee.getBirthdate().format(formatter)));
        employee.setSex(employeeDto.getSex());
        employee.setStreet(employeeDto.getStreet());
        employee.setCity(employeeDto.getCity());
        employee.setZip(employeeDto.getZip());
        employee.setCountry(employeeDto.getCountry());
        employee.setEmail(employeeDto.getEmail());
        employee.setTelephone(employeeDto.getTelephone());
        employee.setSalary(employeeDto.getSalary());
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(employeeDto.getPassword());
        return mapper.toDto(employee);
    }
    

    public void deleteById(long employee_id){
        EmployeeDto employeeDto = getEmployeeById(employee_id);
        Employee employee = mapper.toEntity(employeeDto);
        repository.delete(employee);
    }

    public EmployeeDto createServEmpWithRelation(EmployeeDto employeeDto){
        Employee  employee = mapper.toEntity(employeeDto);
        Integer service_id = restTemplate.getForEntity("http://SERVICE/services/service_id"
        + employeeDto.getService_id(), Integer.class).getBody();
        employee = repository.save(employee);
        Map<String, Integer> map = new HashMap<>();
        map.put("service_id", service_id);
        map.put("employee_id", (int) employee.getEmployee_id());
        restTemplate.getForEntity("http://Service_Employee/EmployeeService/{employee_id}/{service_id}" ,
                void.class, map);
        EmployeeDto employeeDto1 = mapper.toDto(employee);
        return employeeDto1;
    }


}
