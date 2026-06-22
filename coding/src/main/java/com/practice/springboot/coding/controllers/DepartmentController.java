package com.practice.springboot.coding.controllers;

import com.practice.springboot.coding.dto.DepartmentDTO;
import com.practice.springboot.coding.dto.EmployeeDTO;
import com.practice.springboot.coding.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
      return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<List<DepartmentDTO>> getDepartmentById(@PathVariable Long departmentId) {
        DepartmentDTO department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(List.of(department), HttpStatus.OK);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartmentById(departmentDTO, departmentId);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }
    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long departmentId) {

        Boolean gotDeleted = departmentService.deleteDepartment(departmentId);
        if (gotDeleted){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updatePartialDepartment(@RequestBody Map<String, Object> updates, @PathVariable Long departmentId) {
        DepartmentDTO departmentDTO = departmentService.updatePartialEmployeeById(updates, departmentId);
        if(departmentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }
}
