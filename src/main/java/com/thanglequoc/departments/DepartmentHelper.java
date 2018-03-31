package com.thanglequoc.departments;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanglequoc.common.GenericModelMapper;

@Component
public class DepartmentHelper implements GenericModelMapper<DepartmentEntity, DepartmentDto> {
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DepartmentDto> convertToDtos(List<DepartmentEntity> entities) {
	if (CollectionUtils.isEmpty(entities)) {
	    return Collections.emptyList();
	}
	return entities
		.stream()
		.map(entity -> convertToDto(entity))
		.collect(Collectors.toList());
    }

    @Override
    public DepartmentDto convertToDto(DepartmentEntity entity) {
	return modelMapper.map(entity, DepartmentDto.class);
    }

}
