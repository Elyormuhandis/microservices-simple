package uz.muhandis.employeeservice.service;

import uz.muhandis.employeeservice.dto.APIResponse;
import uz.muhandis.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponse getEmployeeById(Long id);
}
