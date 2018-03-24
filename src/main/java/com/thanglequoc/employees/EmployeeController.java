package com.thanglequoc.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value="/{id}" ,method = RequestMethod.GET)
    public EmployeeDto getEmployee(@PathVariable Long id) {
	return employeeService.getEmployeeById(id);
    }
       
}
