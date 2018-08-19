package com.thanglequoc.employees.titles;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeTitleId implements Serializable {

    private static final long serialVersionUID = 7504446698187428114L;

    @Column(name = "emp_no")
    private Long employeeId;

    @Column(name = "title")
    private Long titleId;

    public EmployeeTitleId(Long employeeId, Long titleId) {
        this.employeeId = employeeId;
        this.titleId = titleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (! (obj instanceof EmployeeTitleEntity)) {
            return false;
        }
        EmployeeTitleId that = (EmployeeTitleId)obj;
        return Objects.equals(getEmployeeId(), that.getEmployeeId()) &&
                Objects.equals(getTitleId(), that.getTitleId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getTitleId());
    }
}
