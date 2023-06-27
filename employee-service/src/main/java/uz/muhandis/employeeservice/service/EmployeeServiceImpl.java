package uz.muhandis.employeeservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import uz.muhandis.employeeservice.dto.APIResponse;
import uz.muhandis.employeeservice.dto.DepartmentDto;
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
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final APIClient apiClient;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = employeeRepository.save(employeeMapper.dtoToEmployee(employeeDto));
        return employeeMapper.employeeToDto(savedEmployee);
    }

    @Override
    public APIResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", String.valueOf(id)));
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        if (!departmentDtoResponseEntity.hasBody()){
//            throw new ResourceNotFoundException("Department", "code", employee.getDepartmentCode());
//        }
//            DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        return employeeMapper.dtoToResponse(employee, departmentDto);
    }
}
