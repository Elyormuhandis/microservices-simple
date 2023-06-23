package uz.muhandis.employeeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.employeeservice.dto.EmployeeDto;
import uz.muhandis.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto foundEmployee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
    }
}
