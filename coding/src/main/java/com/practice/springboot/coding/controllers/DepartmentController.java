package com.practice.springboot.coding.controllers;

import com.practice.springboot.coding.dto.DepartmentDTO;
import com.practice.springboot.coding.dto.EmployeeDTO;
import com.practice.springboot.coding.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<DepartmentDTO> getAllDepartments() {
        DepartmentDTO departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

}
