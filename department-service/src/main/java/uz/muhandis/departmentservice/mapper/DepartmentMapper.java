package uz.muhandis.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.muhandis.departmentservice.dto.DepartmentCodeDto;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department dtoToDepartment(DepartmentDto departmentDto);

    DepartmentDto departmentToDto(Department department);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departmentName", ignore = true)
    @Mapping(target = "departmentDescription", ignore = true)
    @Mapping(target = "departmentCode", source = "dto.code" )
    Department codeDtoToDepartment(DepartmentCodeDto dto);
}
