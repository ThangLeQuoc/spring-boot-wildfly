package com.thanglequoc.employees.salary;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanglequoc.common.GenericModelMapper;

@Component
public class SalaryHelper implements GenericModelMapper<SalaryEntity, SalaryDto>  {
    
    @Autowired
    ModelMapper mapper;

    @Override
    public List<SalaryDto> convertToDtos(List<SalaryEntity> entities) {
	List<SalaryDto> salaryDtos = entities.stream()
		.map(this::convertToDto)
		.collect(Collectors.toList());
	return salaryDtos;
    }

    @Override
    public SalaryDto convertToDto(SalaryEntity entity) {
	SalaryDto salaryDto = mapper.map(entity, SalaryDto.class);
	return salaryDto;
    }
    
    
}
