package com.practice.springboot.coding.controllers;

import com.practice.springboot.coding.dto.EmployeeDTO;
import com.practice.springboot.coding.entities.EmployeeEntity;
import com.practice.springboot.coding.repositories.EmployeeRepository;
import com.practice.springboot.coding.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping("/employeesSecretMessage")
//    public String getSecretMessage() {
//        return "This is a secret message for employees only!";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") Long Id) {
       return employeeService.getEmployeeById(Id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
       return employeeService.createEmployee(employeeDTO);
    }

}
