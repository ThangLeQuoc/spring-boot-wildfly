package com.thanglequoc.employees.titles;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.thanglequoc.employees.EmployeeEntity;

@Entity
@Table(name = "emp_titles")
public class EmployeeTitleEntity {
    
    @EmbeddedId
    private EmployeeTitleId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("employeeId")
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
    private EmployeeEntity employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("titleId")
    @JoinColumn(name = "title", referencedColumnName = "id")
    private TitleEntity title;
    
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    
    public EmployeeTitleEntity() {
        
    }

    public EmployeeTitleId getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public TitleEntity getTitle() {
        return title;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setId(EmployeeTitleId id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setTitle(TitleEntity title) {
        this.title = title;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        } 
        EmployeeTitleEntity that = (EmployeeTitleEntity) obj;
        
        return Objects.equals(employee, that.employee) &&
                Objects.equals(title, that.title);
        
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(employee, title);
    }
    
}
