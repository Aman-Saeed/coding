package com.practice.springboot.coding.controllers;

import com.practice.springboot.coding.entities.EmployeeEntity;
import com.practice.springboot.coding.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping("/employeesSecretMessage")
//    public String getSecretMessage() {
//        return "This is a secret message for employees only!";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable("employeeId") Long employeeId) {
       return employeeRepository.getReferenceById(employeeId);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }
    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
       return employeeRepository.save(employeeEntity);
    }

}
