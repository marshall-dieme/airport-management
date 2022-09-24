package com.saraya.employeeservice.service;

import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.model.EmployeeDto;
import com.saraya.employeeservice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private ModelMapper mapper;
     private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Employee getByUsername(String username){
        return repo.findByUsername(username);
    }

    public Employee create ( EmployeeDto dto){
    	Employee employee = mapper.map(dto, Employee.class);
        return repo.save(employee);
    }

    public Employee update(Employee employee){
        return repo.save(employee);
    }

    public void deleteByUsername(String username){
        Employee employee = repo.findByUsername(username);
        repo.delete(employee);
    }

    public void deleteById(int employeeId){
        repo.deleteById(employeeId);
    }

}
