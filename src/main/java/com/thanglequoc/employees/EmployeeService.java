package com.thanglequoc.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  {
    
    @Autowired
    private EmployeesRepository employeeRepository;
    
    @Autowired
    private EmployeeHelper employeeHelper;
  
    public List<EmployeeEntity> getAllEmployeesEntity() {
	return employeeRepository.findAll();
    }
    
    public EmployeeEntity getEmployeeEntityById(Long id) {
	return employeeRepository.findOne(id);
    }
    
    public List<EmployeeDto> getAllEmployees() {
	return employeeHelper.convertToDtos(getAllEmployeesEntity());
    }
    
    public EmployeeDto getEmployeeById(Long id) {
	EmployeeEntity employee = getEmployeeEntityById(id);
	return employeeHelper.convertToDto(employee);
    }
}
