package com.saraya.employeeservice.services;

import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.model.EmployeeDto;
import com.saraya.employeeservice.repos.EmpRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.println;

@Service
public class EmpService {

    private final EmpRepo repo;

    public EmpService(EmpRepo repo) {
        this.repo = repo;
    }


    public List<Employee> getAll(){
        return repo.findAll();

    }

    public List<Employee> getByServices(String serviceName) {
        Map<String, String> values = new HashMap<>();
        values.put("serviceName", serviceName);
        RestTemplate template = new RestTemplate();
        Long serviceId = template.getForEntity("http://localhost:8300/services/serviceName/{serviceName}",
                Long.class, values).getBody();

        return repo.findByServiceId(serviceId);
    }


    public Employee create(EmployeeDto dto) {
        Employee emp= new Employee();
        RestTemplate template = new RestTemplate();
        Map<String, String> values = new HashMap<>();
        values.put("serviceName", dto.getServiceName());
        Long idServices = template.getForEntity("http://localhost:8300/services/serviceName/{serviceName}",
                Long.class, values).getBody();
        changeToModel(dto, emp);
        emp.setServiceId(idServices);
        return repo.save(emp);
    }



    public Employee createWithRelation(EmployeeDto dto) {
        Employee emp = new Employee();
        changeToModel(dto, emp);
        Map<String, String> values1 = new HashMap<>();
        values1.put("serviceName", dto.getServiceName());
        Long idService =  new RestTemplate().getForEntity(
                "http://localhost:8300/services/serviceName/{serviceName}",
                Long.class, values1).getBody();
        emp.setServiceId(idService);
       System.out.println(emp.getServiceId());
        emp = repo.save(emp);
        Map<String, Long> values = new HashMap<>();
        values.put("serviceId", idService);
        values.put("employeeId", emp.getEmployeeId() );
        new RestTemplate().getForEntity("http://localhost:8700/empserv/{serviceId}/{employeeId}",
                Void.class, values);
        return emp;


    }

    private void changeToModel(EmployeeDto dto, Employee emp) {
       emp.setFirstname(dto.getFirstname());
       emp.setLastname(dto.getLastname());
       emp.setEmail(dto.getEmail());
       emp.setCountry(dto.getCountry());
       emp.setSalary(dto.getSalary());
       emp.setSex(dto.getSex());
       emp.setStreet(dto.getStreet());
       emp.setTelephone(dto.getTelephone());
       emp.setUsername(dto.getUsername());
       emp.setZip(dto.getZip());
       emp.setPassword(dto.getPassword());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthdate = LocalDate.parse(dto.getBirthdate(), format);
        emp.setBirthdate(birthdate);
       emp.setCity(dto.getCity());

    }






    public Employee update(EmployeeDto dto){

        Employee emp = new Employee();
        emp.setEmployeeId(dto.getEmployeeId());
        changeToModel(dto, emp);;
        return repo.save(emp);
    }




    public void delete(Long id ){
        repo.deleteById(id);
    }
}
