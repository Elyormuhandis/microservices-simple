package uz.muhandis.employeeservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

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

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name ="${spring.application.name}", fallbackMethod="getDefaultDepartment" )
    @Override
    public APIResponse getEmployeeById(Long id) {
        LOGGER.info("Inside of getEmployeeById() method");
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

    public APIResponse getDefaultDepartment(Long employeeId, Exception exception) {
        LOGGER.info("Inside of getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", String.valueOf(employeeId)));

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
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D department");
        departmentDto.setDepartmentDescription("Research and Development");
        departmentDto.setDepartmentCode("RD001");

        return employeeMapper.dtoToResponse(employee, departmentDto);

    }
}
