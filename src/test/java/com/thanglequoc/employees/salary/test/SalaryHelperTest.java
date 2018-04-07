package com.thanglequoc.employees.salary.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thanglequoc.employees.salary.SalaryDto;
import com.thanglequoc.employees.salary.SalaryEntity;
import com.thanglequoc.employees.salary.SalaryHelper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SalaryHelperTest {
    
    @Autowired
    private SalaryHelper salaryHelper;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    @Test
    public void should_ReturnOneSalaryDto_When_ReduceListOfSalaryEntityOfOneEmployee() throws ParseException {
	List<SalaryEntity> salaries = prepareSalaryEntitiesOfOneEmployee();
	salaryHelper.reduceSalariesByEmployee(salaries);
	List<SalaryDto> expectedSalaryDto = salaryHelper.reduceSalariesByEmployee(salaries);
	assertEquals(1, expectedSalaryDto.size());
	
	SalaryDto salaryOfEmployee1 = expectedSalaryDto.get(0);
	assertEquals(2, salaryOfEmployee1.getSalaries().size());
    }
    
    private List<SalaryEntity> prepareSalaryEntitiesOfOneEmployee() throws ParseException {
	List<SalaryEntity> salaryEntities = new ArrayList<>();
	
	SalaryEntity salary1 = new SalaryEntity();
	salary1.setEmployeeId(1L);
	salary1.setFromDate(sdf.parse("05-04-2017"));
	salary1.setToDate(sdf.parse("05-05-2017"));
	salary1.setSalary(200);
	salaryEntities.add(salary1);
	
	SalaryEntity salary2 = new SalaryEntity();
	salary2.setEmployeeId(1L);
	salary2.setFromDate(sdf.parse("06-05-2017"));
	salary2.setToDate(sdf.parse("06-06-2017"));
	salary2.setSalary(300);
	salaryEntities.add(salary2);
	
	return salaryEntities;
    }
    
}
