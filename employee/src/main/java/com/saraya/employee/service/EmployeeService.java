package com.saraya.employee.service;

import com.saraya.employee.model.Employee;
import com.saraya.employee.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EmployeeService<Employee> {

   private  final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }
    public List<Employee> getAll() {
        return repo.findAll();
    }
    public Employee create(Employee employee){
        return (Employee) repo.save(employee);
    }
    public Employee update(Employee employee){
        return (Employee) repo.save(employee);
    }
    public void delete(Double id){
        repo.deleteById(id);
    }
   /* public  Double getIdAirport(String firstname,
                                        String lastname,
                                        LocalDate birthdate,
                                        String sex,
                                        String street,
                                        String city,
                                        String zip,
                                        String country,
                                        String email,
                                        int telephone,
                                        Double salary,
                                        String username,
                                        String password){
        return repo.getIdAirportByfirstnameandlastnameandbirthdateandsexandstreetandcityandzipandcountryandemailandtelephoneandsalaryandusernameandpassword( String firstname,
       lastname,
        birthdate,
         sex,
          street,
         city,
         zip,
         country,
          email,
         telephone,
           salary,
           username,
          password);
    }*/
}
