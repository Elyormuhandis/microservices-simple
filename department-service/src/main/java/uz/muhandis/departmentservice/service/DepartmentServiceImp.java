package uz.muhandis.departmentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.entity.Department;
import uz.muhandis.departmentservice.mapper.DepartmentMapper;
import uz.muhandis.departmentservice.repository.DepartmentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department jpa entity
        Department savedDepartment = departmentRepository.save(departmentMapper.dtoToDepartment(departmentDto));
        return departmentMapper.departmentToDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Optional<Department> optional = departmentRepository.findDepartmentByDepartmentCode(code);
        if (optional.isPresent())
            return departmentMapper.departmentToDto(optional.get());
        return new DepartmentDto();
    }
}
