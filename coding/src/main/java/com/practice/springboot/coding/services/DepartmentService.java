package com.practice.springboot.coding.services;

import com.practice.springboot.coding.dto.DepartmentDTO;
import com.practice.springboot.coding.dto.EmployeeDTO;
import com.practice.springboot.coding.entities.DepartmentEntity;
import com.practice.springboot.coding.entities.EmployeeEntity;
import com.practice.springboot.coding.exceptions.ResourceNotFoundException;
import com.practice.springboot.coding.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long departmentId) {
        var departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public Boolean deleteDepartment(Long departmentId) {
        isExistByDepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public void isExistByDepartmentId(Long departmentId) {
        Boolean isExist = departmentRepository.existsById(departmentId);
        if(!isExist) throw new ResourceNotFoundException("Department not found with id: " + departmentId);

    }

    public DepartmentDTO updatePartialEmployeeById(Map<String, Object> updates, Long departmentId) {

        isExistByDepartmentId(departmentId);

        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((key, value) -> {

            Field fieldToBeUpdated = ReflectionUtils.findField(DepartmentEntity.class, key);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Long departmentId) {

        isExistByDepartmentId(departmentId);

        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity updatedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(updatedDepartmentEntity, DepartmentDTO.class);
    }
}
