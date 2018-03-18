package com.thanglequoc.employees;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeesRepository employeeRepository;
    
    private ModelMapper mapper;
    
    public List<EmployeeEntity> getAllEmployees() {
	return employeeRepository.findAll();
    }
    
    
}
