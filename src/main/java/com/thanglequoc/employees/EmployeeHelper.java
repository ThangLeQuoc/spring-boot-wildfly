package com.thanglequoc.employees;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanglequoc.common.GenericModelMapper;

@Component
public class EmployeeHelper implements GenericModelMapper<EmployeeEntity, EmployeeDto> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<EmployeeDto> convertToDtos(List<EmployeeEntity> entities) {
        if (CollectionUtils.isNotEmpty(entities)) {
            return entities.stream().map(employeeEntity -> convertToDto(employeeEntity)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public EmployeeDto convertToDto(EmployeeEntity entity) {
        EmployeeDto employee = mapper.map(entity, EmployeeDto.class);
        employee.setEmpNo(entity.getId());
        return employee;
    }
}
