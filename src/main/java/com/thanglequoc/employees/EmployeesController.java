package com.thanglequoc.employees;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String getEmployees() {
	return "This should get all employees";
    }
    
    @RequestMapping(value="/{id}" ,method = RequestMethod.GET)
    public String getEmployee(@PathVariable String id) {
	return "This should get employee with id: "+id;
    }
    
}
