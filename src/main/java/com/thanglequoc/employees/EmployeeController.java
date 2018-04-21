package com.thanglequoc.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thanglequoc.employees.salary.SalaryDto;
import com.thanglequoc.employees.salary.SalaryEntity;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
        
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeDto> getEmployees() {	
	return employeeService.getAllEmployees();
    }
    
    
    @GetMapping( headers={"x-pageable-response=true"} )
    public Page<EmployeeDto> getEmployeesPageable(Pageable pageable){
	return employeeService.getAllEmployeesPages(pageable);	
    }
    
    @RequestMapping(value="/{id}" ,method = RequestMethod.GET)
    public EmployeeDto getEmployee(@PathVariable Long id) {
	return employeeService.getEmployeeById(id);
    }
    
    @RequestMapping(value = "/{id}/salaries", method = RequestMethod.GET)
    public SalaryDto getSalaryOfEmployee(@PathVariable Long id) {
	return employeeService.getSalaryByEmployee(id);
    }
       
}
