package com.thanglequoc.employees;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thanglequoc.employees.salary.SalaryDto;
import com.thanglequoc.employees.salary.SalaryEntity;
import com.thanglequoc.employees.salary.SalaryHelper;
import com.thanglequoc.employees.titles.EmployeeTitleDto;
import com.thanglequoc.employees.titles.EmployeeTitleEntity;
import com.thanglequoc.employees.titles.TitleEntity;
import com.thanglequoc.employees.titles.TitleMapper;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeesRepository employeeRepository;

    @Autowired
    private EmployeeHelper employeeHelper;

    @Autowired
    private SalaryHelper salaryHelper;
    

    public Page<EmployeeDto> getAllEmployeesPages(Pageable pageable) {
        Page<EmployeeEntity> result = employeeRepository.findAll(pageable);
        return result.map(employeeHelper::convertToDto);
    }

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

    public SalaryDto getSalaryByEmployee(Long employeeId) {
        List<SalaryEntity> salariesOfEmployee = getEmployeeEntityById(employeeId).getSalaries();
        return salaryHelper.reduceSalariesByEmployee(salariesOfEmployee).get(0);
    }
    
    public List<EmployeeTitleEntity> getEmployeeTitleEntityByEmployee(Long employeeId) {
        return employeeRepository.findOne(employeeId).getTitles();
    }
    
    public List<EmployeeTitleDto> getEmployeeTitleByEmployee(Long employeeId) {
        return this.getEmployeeTitleEntityByEmployee(employeeId).stream()
                .map(TitleMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
