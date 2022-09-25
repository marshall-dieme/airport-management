package com.spring.employees.service;

import com.spring.employees.DTO.EmployeeDto;
import com.spring.employees.bean.Employee;
import com.spring.employees.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public Employee create(Employee employee){
     return employeeRepo.save(employee)  ;
    }

    public Employee update(Employee employee){
        return employeeRepo.save(employee);

    }
    public void delete(int id){
        employeeRepo.deleteById(id);
    }

    public Employee createWithRelation(EmployeeDto dto) {
        Employee emp = new Employee();
        changeToModel(dto, emp);
        String idDept = new RestTemplate().getForEntity(
                "http://localhost:8400/services/name/"+dto.getService(),
                String.class).getBody();
        emp = employeeRepo.save(emp);
        Map<String, String> values = new HashMap<>();
        values.put("idDept", idDept);
        values.put("idEmp", String.valueOf(emp.getEmployeeId()));
        new RestTemplate().getForEntity("http://localhost:8900/relation/{idService}/{idEmployee}",
                Void.class, values);

        return emp;
    }
    private static void changeToModel(EmployeeDto dto, Employee employee) {
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setBirthday(LocalDate.parse(dto.getBirthday()));
        employee.setSex(dto.getSex());
        employee.setStreet(dto.getStreet());
        employee.setCity(dto.getCity());
        employee.setZip(dto.getZip());
        employee.setCountry(employee.getCountry());
        employee.setCity(employee.getCity());
        employee.setEmail(employee.getEmail());
        employee.setTelephone(employee.getTelephone());
        employee.setSalary(employee.getSalary());
        employee.setUsername(employee.getUsername());

        /*DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate hireDate = LocalDate.parse(dto.getHireDate(), format);*/
        /*employee.setHireDate(hireDate);*/
    }
}
