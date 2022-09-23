package com.saraya.employeeservice.service;

import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
     private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Employee getByFirstName(String firstName){
        return repo.findByFirstName(firstName);
    }

    public Employee create (Employee employee){
        return repo.save(employee);
    }

    public Employee update(Employee employee){
        return repo.save(employee);
    }

    public void deleteByFirstName(String firstName){
        Employee employee = repo.findByFirstName(firstName);
        repo.delete(employee);
    }

    public void deleteById(int employeeId){
        repo.deleteById(employeeId);
    }

}
