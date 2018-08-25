package com.thanglequoc.employees.titles;

import java.util.Date;

public class EmployeeTitleDto {
    
    private String position;
    private Date from;
    private Date to;
    
    public String getPosition() {
        return position;
    }
    public Date getFrom() {
        return from;
    }
    public Date getTo() {
        return to;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setFrom(Date from) {
        this.from = from;
    }
    public void setTo(Date to) {
        this.to = to;
    }
    
}
