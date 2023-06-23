package uz.muhandis.departmentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.entity.Department;
import uz.muhandis.departmentservice.exceptions.DepartmentAlreadyExistException;
import uz.muhandis.departmentservice.exceptions.ResourceNotFoundException;
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
        Optional<Department> departmentByDepartmentCode = departmentRepository.findDepartmentByDepartmentCode(departmentDto.getDepartmentCode());
        if (departmentByDepartmentCode.isPresent())
            throw new DepartmentAlreadyExistException("This department already exist");
        Department savedDepartment = departmentRepository.save(departmentMapper.dtoToDepartment(departmentDto));
        return departmentMapper.departmentToDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "code", code));
        return departmentMapper.departmentToDto(department);
    }
}
