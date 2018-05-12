package com.thanglequoc.employees;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {
    
    List<EmployeeEntity> findAll();
    Page<EmployeeEntity> findAll(Pageable pageAble);
}
