package com.thanglequoc.employees.titles;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "titles")
public class TitleEntity implements Serializable {

    private static final long serialVersionUID = 5947851904057460762L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeTitleEntity> employeeTitle;

    public TitleEntity() {
    
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeTitleEntity> getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(List<EmployeeTitleEntity> employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

}
