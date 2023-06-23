package uz.muhandis.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.departmentservice.dto.DepartmentDto;
import uz.muhandis.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //Build save department REST API

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String code){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }


}
