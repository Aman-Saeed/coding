package com.practice.springboot.coding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Title cannot be Blank")
    @Size(min = 5, max = 20, message = "Title must be between 5 and 20 characters")
    private String title;

    @AssertTrue(message = "isActive must be true")
    @JsonProperty("isActive")
    private Boolean isActive;

    @Past(message = "Created At must be in the past")
    private LocalDate createdAt;
}
