package com.practice.springboot.coding.repositories;

import com.practice.springboot.coding.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositories extends JpaRepository<EmployeeEntity, Long> {
}
