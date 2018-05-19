package com.thanglequoc.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentHelper departmentHelper;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DepartmentEntity> getAllDepartmentEntity() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity getDepartmentEntityById(String id) {
        return departmentRepository.findOne(id);
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = getAllDepartmentEntity();
        return departmentHelper.convertToDtos(departmentEntities);
    }

    public DepartmentDto getDepartmentById(String id) {
        DepartmentEntity departmentEntity = getDepartmentEntityById(id);
        return departmentHelper.convertToDto(departmentEntity);
    }

}
