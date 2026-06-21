package com.practice.springboot.coding.services;

import com.practice.springboot.coding.dto.DepartmentDTO;
import com.practice.springboot.coding.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        var departmentEntity = modelMapper.map(departmentDTO, com.practice.springboot.coding.entities.DepartmentEntity.class);
        var savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO getAllDepartments() {
        var departmentEntities = departmentRepository.findAll();
        return modelMapper.map(departmentEntities, DepartmentDTO.class);
    }
}
