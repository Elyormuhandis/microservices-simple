package uz.muhandis.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    DepartmentDto findDepartmentByDepartmentCode(String departmentCode);

}
