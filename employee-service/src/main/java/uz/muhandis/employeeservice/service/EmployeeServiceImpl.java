package uz.muhandis.employeeservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhandis.employeeservice.dto.EmployeeDto;
import uz.muhandis.employeeservice.entity.Employee;
import uz.muhandis.employeeservice.exceptions.ResourceNotFoundException;
import uz.muhandis.employeeservice.mapper.EmployeeMapper;
import uz.muhandis.employeeservice.repository.EmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = employeeRepository.save(employeeMapper.dtoToEmployee(employeeDto));
        return employeeMapper.employeeToDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        return employeeMapper.employeeToDto(employee);
    }
}
