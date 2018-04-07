package com.thanglequoc.employees.salary;

import java.util.Date;

public class DetailSalaryDto {
    private int salary;
    private Date fromDate;
    private Date toDate;
    
    public int getSalary() {
        return salary;
    }
    public Date getFromDate() {
        return fromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
