package com.thanglequoc.employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {

}
