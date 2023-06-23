package uz.muhandis.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.entity.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findDepartmentByDepartmentCode(String departmentCode);

}
