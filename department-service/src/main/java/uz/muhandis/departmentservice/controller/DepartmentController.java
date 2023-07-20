package uz.muhandis.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.service.DepartmentService;

//For openapi docs
@Tag(name = "Department Service - DepartmentController", description = "Department Controller Exposes REST APIs for Department Service")


@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //For openapi docs
    @Operation(summary = "Save Department REST API", description = "This is used to save Department object in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")


    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }



    @Operation(summary = "Get Department REST API", description = "This is used to get Department object from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")


    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String code) {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }


}
