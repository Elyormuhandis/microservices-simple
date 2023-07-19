package uz.muhandis.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.muhandis.employeeservice.dto.DepartmentDto;
import uz.muhandis.employeeservice.dto.OrganizationDto;


//@FeignClient(url = "http://localhost:8083, http://localhost:8084", value = "ORGANIZATION-SERVICE") //No Load balancing
@FeignClient(name = "ORGANIZATION-SERVICE")          //With load balancing
public interface OrganizationAPIClient {
    @GetMapping("api/organizations/{organization-code}")
    OrganizationDto getOrganization(@PathVariable("organization-code") String organizationCode);
}
