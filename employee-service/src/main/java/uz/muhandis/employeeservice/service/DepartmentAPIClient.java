package uz.muhandis.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.muhandis.employeeservice.dto.DepartmentDto;


//@FeignClient(url = "http://localhost:8080, http://localhost:8082", value = "DEPARTMENT-SERVICE") //No Load balancing
@FeignClient(name = "DEPARTMENT-SERVICE")          //With load balancing
public interface DepartmentAPIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
