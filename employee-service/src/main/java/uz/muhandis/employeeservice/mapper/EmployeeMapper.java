package uz.muhandis.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.muhandis.employeeservice.dto.APIResponse;
import uz.muhandis.employeeservice.dto.DepartmentDto;
import uz.muhandis.employeeservice.dto.EmployeeDto;
import uz.muhandis.employeeservice.dto.OrganizationDto;
import uz.muhandis.employeeservice.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto employeeToDto(Employee employee);
    Employee dtoToEmployee(EmployeeDto employee);

    @Mapping(target = "employee", source = "employee")
    @Mapping(target = "department", source = "department")
    @Mapping(target = "organization", source = "organization")
    APIResponse dtoToResponse(Employee employee, DepartmentDto department, OrganizationDto organization);
}
