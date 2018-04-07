package com.thanglequoc.employees.salary;

import java.io.Serializable;
import java.util.Date;

public class SalaryPK implements Serializable {
    
    protected Long employeeId;
    protected Date fromDate;
    
    public SalaryPK() {
    }
    
    public SalaryPK(Long employeeId, Date fromDate) {
	this.employeeId = employeeId;
	this.fromDate = fromDate;
    }
    
}
