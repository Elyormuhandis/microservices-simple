package uz.muhandis.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.employeeservice.dto.APIResponse;
import uz.muhandis.employeeservice.dto.EmployeeDto;
import uz.muhandis.employeeservice.service.EmployeeService;

//For openapi docs
@Tag(name = "Employee Service - EmployeeController", description = "Employee Controller Exposes REST APIs for Employee Service")


@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    //For openapi docs
    @Operation(summary = "Save Employee REST API", description = "This is used to save Employee object in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")


    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(summary = "Get Employee, Organization and Department REST API", description = "This is used to get Employee, Organization and Department object from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")


    @GetMapping("{id}")
    public ResponseEntity<APIResponse> getEmployeeById(@PathVariable Long id) {
        APIResponse apiResponse = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
