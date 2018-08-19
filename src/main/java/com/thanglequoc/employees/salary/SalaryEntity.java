package com.thanglequoc.employees.salary;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.thanglequoc.employees.EmployeeEntity;

@Entity
@Table(name = "salaries")
@IdClass(SalaryPK.class)
public class SalaryEntity implements Serializable {

    private static final long serialVersionUID = 4000746798616871524L;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "emp_no")
    private EmployeeEntity employee;
    
    @Column(name = "salary")
    private int salary;

    @Id
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

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
    
    public EmployeeEntity getEmployee() {
        return employee;
    }
    
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

}
