package uz.muhandis.employeeservice.mapper;

import org.mapstruct.Mapper;
import uz.muhandis.employeeservice.dto.EmployeeDto;
import uz.muhandis.employeeservice.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto employeeToDto(Employee employee);
    Employee dtoToEmployee(EmployeeDto employeeDto);
}
