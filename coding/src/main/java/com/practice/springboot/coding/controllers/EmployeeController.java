package com.practice.springboot.coding.controllers;

import com.practice.springboot.coding.dto.EmployeeDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

//    @GetMapping("/employeesSecretMessage")
//    public String getSecretMessage() {
//        return "This is a secret message for employees only!";
//    }


    @GetMapping("/employees/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return new EmployeeDTO(employeeId, "Aman Saeed", "amansaeed899@gmail.com", 25, LocalDate.of(2024,1,1), true);
    }

    @GetMapping("/employees")
    public String getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy) {
        return "age is  = " + age + " and sortBy is = " + sortBy;
    }


}
