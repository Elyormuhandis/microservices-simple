package uz.muhandis.employeeservice.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uz.muhandis.employeeservice.dto.APIResponse;
import uz.muhandis.employeeservice.dto.DepartmentDto;
import uz.muhandis.employeeservice.dto.EmployeeDto;
import uz.muhandis.employeeservice.dto.OrganizationDto;
import uz.muhandis.employeeservice.entity.Employee;
import uz.muhandis.employeeservice.exceptions.ResourceNotFoundException;
import uz.muhandis.employeeservice.mapper.EmployeeMapper;
import uz.muhandis.employeeservice.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final DepartmentAPIClient departmentApiClient;
    private final OrganizationAPIClient organizationAPIClient;


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
        DepartmentDto departmentDto = departmentApiClient.getDepartment(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationAPIClient.getOrganization(employee.getOrganizationCode());
        return employeeMapper.dtoToResponse(employee, departmentDto, organizationDto);
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
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationName("Tax Comittee");
        organizationDto.setOrganizationDescription("Tax Comittee of Republic of Uzbekistan");
        organizationDto.setOrganizationCode("UZTAX");
        return employeeMapper.dtoToResponse(employee, departmentDto, organizationDto);

    }
}
