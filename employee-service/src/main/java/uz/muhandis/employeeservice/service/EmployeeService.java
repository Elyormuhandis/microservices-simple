package uz.muhandis.employeeservice.service;

import uz.muhandis.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
}
