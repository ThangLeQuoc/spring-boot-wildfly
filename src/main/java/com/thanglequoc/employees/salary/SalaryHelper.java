package com.thanglequoc.employees.salary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanglequoc.common.GenericModelMapper;

@Component
public class SalaryHelper implements GenericModelMapper<SalaryEntity, SalaryDto> {

    @Autowired
    ModelMapper mapper;

    @Override
    public List<SalaryDto> convertToDtos(List<SalaryEntity> entities) {
        List<SalaryDto> salaryDtos = entities.stream().map(this::convertToDto).collect(Collectors.toList());
        return salaryDtos;
    }

    @Override
    public SalaryDto convertToDto(SalaryEntity entity) {
        SalaryDto salaryDto = mapper.map(entity, SalaryDto.class);
        return salaryDto;

    }

    public List<SalaryDto> reduceSalariesByEmployee(List<SalaryEntity> entities) {
        List<SalaryDto> salaries = new ArrayList<>();

        Map<Long, List<SalaryEntity>> salaryEntityMap = new HashMap<>();
        entities.stream().forEach(salary -> {
            if (Objects.isNull(salaryEntityMap.get(salary.getEmployeeId()))) {
                salaryEntityMap.put(salary.getEmployeeId(), new ArrayList<>());
            }
            salaryEntityMap.get(salary.getEmployeeId()).add(salary);
        });

        salaryEntityMap.forEach((employeeId, salariesEntities) -> {
            salaries.add(cruchSalariesEntityOfEmployeeToSalaryDto(salariesEntities));
        });

        return salaries;
    }

    private SalaryDto cruchSalariesEntityOfEmployeeToSalaryDto(List<SalaryEntity> salaries) {
        if (CollectionUtils.isEmpty(salaries))
            throw new IllegalArgumentException();
        SalaryDto salaryDto = new SalaryDto(salaries.get(0).getEmployeeId());
        List<DetailSalaryDto> detailSalaries = salaries.stream().map(salary -> {
            DetailSalaryDto detailSalary = new DetailSalaryDto();
            detailSalary.setSalary(salary.getSalary());
            detailSalary.setFromDate(salary.getFromDate());
            detailSalary.setToDate(salary.getToDate());
            return detailSalary;
        }).collect(Collectors.toList());
        salaryDto.setSalaries(detailSalaries);
        return salaryDto;
    }
}
