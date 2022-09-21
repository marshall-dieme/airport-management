package com.example.employee.service;

import com.example.employee.bean.Employee;
import com.example.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
