package com.practice.springboot.coding.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.springboot.coding.annotations.employeeRoleValidation;
import com.practice.springboot.coding.annotations.salaryPrimeValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
   private Long id;
   @NotBlank(message = "Name cannot be Blank")
   @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters")
   private String name;

   @Email(message = "Email should be valid")
   @NotEmpty(message = "Email cannot be empty")
   private String email;

   @NotNull(message = "Age cannot be null")
   @Max(value = 65, message = "Age should not be greater than 65")
   @Min(value = 18, message = "Age should not be less than 18")
   private Integer age;

   @Past(message = "Date of Joining must be in the past")
   private LocalDate dateOfJoining;


   @NotNull(message = "Salary cannot be null")
   @Positive(message = "Salary must be positive")
   @Digits(integer = 6, fraction = 2, message = "Salary must be a valid monetary amount")
   @DecimalMax(value = "999999.99", message = "Salary must not exceed 999,999.99")
   @DecimalMin(value = "10000.00", message = "Salary must be at least 10000.00")
   @salaryPrimeValidation
   private Double salary;

   @NotBlank(message = "Role cannot be Blank")
   //@Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be either ADMIN or USER")
   @employeeRoleValidation
   private String role;

   @AssertTrue(message = "isActive must be true")
    @JsonProperty("isActive")
    private Boolean isActive;
}
