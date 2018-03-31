package com.thanglequoc.employees;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanglequoc.employees.salary.SalaryDto;
import com.thanglequoc.employees.salary.SalaryEntity;
import com.thanglequoc.employees.salary.SalaryHelper;

@Service
public class EmployeeService  {
    
    @Autowired
    private EmployeesRepository employeeRepository;
    
    @Autowired
    private EmployeeHelper employeeHelper;
    
    @Autowired
    private SalaryHelper salaryHelper;
  
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
    
    public List<SalaryEntity> getSalaryEntityByEmployee(Long employeeId) {
	return employeeRepository.findOne(employeeId).getSalaries();
    }
    
    public List<SalaryDto> getSalaryByEmployee(Long employeeId) {
	List<SalaryEntity> salariesOfEmployee = getSalaryEntityByEmployee(employeeId);
	return salaryHelper.convertToDtos(salariesOfEmployee);
    }
}
