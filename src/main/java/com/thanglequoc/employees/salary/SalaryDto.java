package com.thanglequoc.employees.salary;

import java.util.List;

public class SalaryDto {

    private Long employeeId;
    private List<DetailSalaryDto> salaries;

    public SalaryDto() {
    }

    public SalaryDto(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public List<DetailSalaryDto> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<DetailSalaryDto> salaries) {
        this.salaries = salaries;
    }
}
