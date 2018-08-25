package com.thanglequoc.employees.titles;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

public class TitleMapper {

    public static List<EmployeeTitleDto> convertToDtos(List<EmployeeTitleEntity> employeeTitleEntities) {
        if (CollectionUtils.isEmpty(employeeTitleEntities)) {
            return Collections.emptyList();
        }
        return employeeTitleEntities.stream().map(TitleMapper::convertToDto).collect(Collectors.toList());
    }

    public static EmployeeTitleDto convertToDto(EmployeeTitleEntity employeeTitleEntity) {
        if (employeeTitleEntity == null) {
            throw new IllegalArgumentException("EmployeeTitleEntity can not be null");
        }
        EmployeeTitleDto employeeTitleDto = new EmployeeTitleDto();
        employeeTitleDto.setPosition(employeeTitleEntity.getTitle().getName());
        employeeTitleDto.setFrom(employeeTitleEntity.getFromDate());
        employeeTitleDto.setTo(employeeTitleEntity.getToDate());
        return employeeTitleDto;
    }

}
