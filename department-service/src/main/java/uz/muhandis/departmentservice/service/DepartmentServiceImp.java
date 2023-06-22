package uz.muhandis.departmentservice.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.entity.Department;
import uz.muhandis.departmentservice.mapper.DepartmentMapper;
import uz.muhandis.departmentservice.repository.DepartmentRepository;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService{

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department jpa entity
        Department savedDepartment = departmentRepository.save(departmentMapper.dtoToDepartment(departmentDto));
        return departmentMapper.departmentToDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {



        return null;
    }
}
