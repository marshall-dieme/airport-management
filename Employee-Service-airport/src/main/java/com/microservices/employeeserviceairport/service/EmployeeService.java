package com.microservices.employeeserviceairport.service;


import com.microservices.employeeserviceairport.entity.EmployeeDTO;
import com.microservices.employeeserviceairport.entity.Employee;
import com.microservices.employeeserviceairport.repository.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Optional<Employee> getById(Long id_employee){
        return repo.findById(id_employee);
    }

    public Employee create(EmployeeDTO dto){
        Employee employee = new Employee();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("name", dto.getServ());
        String idServ  = template.getForEntity(
                "http://localhost:8002/services/name/{name}",
                String.class).getBody();
        changeToModel(dto, employee);
        employee.setIdServ(idServ);
        return repo.save(employee);
    }

    private void changeToModel(EmployeeDTO dto, Employee employee) {
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        employee.setSexe(dto.getSexe());
        employee.setStreet(dto.getStreet());
        employee.setCity(dto.getCity());
        employee.setZip(dto.getZip());
        employee.setCountry(dto.getCountry());
        employee.setEmail(dto.getEmail());
        employee.setTelephone(dto.getTelephone());
        employee.setSalary(dto.getSalary());
        employee.setUsername(dto.getUsername());
        employee.setPassword(dto.getPassword());

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(dto.getBirthDate(), format);
        employee.setBirthDate(birthDate);
    }

    public Employee update(EmployeeDTO dto){
        Employee employee = new Employee();
        employee.setId_employee(dto.getId_employee());
        changeToModel(dto, employee);
        return repo.save(employee);
    }

    public void delete (Long id_employee){
        repo.deleteById(id_employee);
    }

    public List<Employee> getByServ(String servicesName) {
        Map<String, String> values = new HashMap<>();
        values.put("name", servicesName);
        RestTemplate template = new RestTemplate();
        String idServ = template.getForEntity(
                "http://localhost:8002/services/name/{name}",
                String.class, values).getBody();

        return repo.findByIdServ(idServ);
    }

    public Employee CreateWithRelation(EmployeeDTO dto) {
        Employee employee = new Employee();
        changeToModel(dto, employee);
        String idServ = new RestTemplate().getForEntity(
                "http://localhost:8002/services/name/"+dto.getServ(),
                String.class).getBody();
        employee = repo.save(employee);
        Map<String, String> values = new HashMap<>();
        values.put("idDept", idServ);
        values.put("idEmp", String.valueOf(employee.getId_employee()));
        new RestTemplate().getForEntity(
                "http://localhost:8800/relation/{idServ}/{idEmp}",
                Void.class, values);

        return employee;
    }

}
