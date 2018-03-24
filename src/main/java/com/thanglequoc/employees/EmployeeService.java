package com.thanglequoc.employees;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanglequoc.common.GenericModelMapper;

@Service
public class EmployeeService implements GenericModelMapper<EmployeeEntity, EmployeeDto> {
    
    @Autowired
    private EmployeesRepository employeeRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    public List<EmployeeEntity> getAllEmployeesEntity() {
	return employeeRepository.findAll();
    }
    
    public List<EmployeeDto> getAllEmployees() {
	return convertToDtos(getAllEmployeesEntity());
    }

    @Override
    public List<EmployeeDto> convertToDtos(List<EmployeeEntity> entities) {
	if (CollectionUtils.isNotEmpty(entities)) {
	    return entities.stream()
	    .map(employeeEntity -> convertToDto(employeeEntity))
	    .collect(Collectors.toList());
	}
	return Collections.emptyList();
    }

    @Override
    public EmployeeDto convertToDto(EmployeeEntity entity) {
	return mapper.map(entity, EmployeeDto.class);
    }
    
}
