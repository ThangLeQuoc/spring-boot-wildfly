package com.thanglequoc.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    
    @Autowired
    DepartmentService departmentService;
    
    @GetMapping
    public List<DepartmentDto> getAllDepartments() {
	return departmentService.getAllDepartments();
    }
    
    @GetMapping(path = "/{id}")
    public DepartmentDto getDepartmentById(@PathVariable String id) {
	return departmentService.getDepartmentById(id);
    }
}
