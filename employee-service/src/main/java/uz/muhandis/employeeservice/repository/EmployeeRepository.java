package uz.muhandis.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
