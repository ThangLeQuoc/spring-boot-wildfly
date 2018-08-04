package com.thanglequoc.employees.salary;

import java.io.Serializable;
import java.util.Date;

public class SalaryPK implements Serializable {

    protected Long employee;
    protected Date fromDate;

    public SalaryPK() {
    }

    public SalaryPK(Long employee, Date fromDate) {
        this.employee = employee;
        this.fromDate = fromDate;
    }

}
