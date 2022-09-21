package com.saraya.employeeservice.mappers;

import com.saraya.employeeservice.dto.EmployeeDto;
import com.saraya.employeeservice.models.Employee;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    List<EmployeeDto> employeesToEmployeeDtos(List<Employee> employees);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee updateEmployeeFromEmployeeDto(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
