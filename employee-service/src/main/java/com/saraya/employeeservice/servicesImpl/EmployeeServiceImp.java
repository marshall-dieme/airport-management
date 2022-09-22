package com.saraya.employeeservice.servicesImpl;

import com.saraya.employeeservice.exceptions.ResourceNotFoundException;
import com.saraya.employeeservice.models.Employee;
import com.saraya.employeeservice.repositories.EmployeeRepository;
import com.saraya.employeeservice.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee add(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long employee_id) throws ResourceNotFoundException {
        Optional<Employee> employee = this.employeeRepository.findById(employee_id);
        if (!employee.isPresent())
            throw new ResourceNotFoundException("Employee not available");
        return employee.get();
    }

    @Override
    public Page<Employee> getEmployees(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public void delete(Long employee_id) throws ResourceNotFoundException {
      if (!this.existEmployee(employee_id))
          throw new ResourceNotFoundException("impossible to remove this Employee");

      this.employeeRepository.deleteById(employee_id);
    }

    @Override
    public boolean existEmployee(Long employee_id) {
        return this.employeeRepository.existsById(employee_id);
    }
}
