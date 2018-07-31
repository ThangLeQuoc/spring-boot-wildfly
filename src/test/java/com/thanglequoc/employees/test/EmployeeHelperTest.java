package com.thanglequoc.employees.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thanglequoc.employees.EmployeeDto;
import com.thanglequoc.employees.EmployeeEntity;
import com.thanglequoc.employees.EmployeeHelper;
import com.thanglequoc.employees.Gender;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeHelperTest {

    @SpyBean
    ModelMapper modelMapper;

    @Autowired
    EmployeeHelper employeeHelper;

    private SimpleDateFormat dateFormat;

    @Before
    public void setUp() {
        new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    }

    @Test
    public void should_ReturnListOfEmployeeDto_When_ConvertFromListOfEmployeeEntity() throws ParseException {
        List<EmployeeEntity> employees = prepareSampleListOfEmployeeEntities();

        List<EmployeeDto> actualEmployeeDtos = employeeHelper.convertToDtos(employees);

        assertTrue(CollectionUtils.isNotEmpty(actualEmployeeDtos));
        List<EmployeeDto> expectedEmployeeDtos = prepareSampleListOfEmployeeDto();
        assertEquals(expectedEmployeeDtos.size(), actualEmployeeDtos.size());
        for (int i = 0; i < expectedEmployeeDtos.size(); i++) {
            compareEmployeeDto(expectedEmployeeDtos.get(i), actualEmployeeDtos.get(i));
        }
    }

    private void compareEmployeeDto(EmployeeDto employee1, EmployeeDto employee2) {
        assertEquals(employee1.getFirstName(), employee2.getFirstName());
        assertEquals(employee1.getLastName(), employee2.getLastName());
        assertEquals(employee1.getGender(), employee2.getGender());
        assertEquals(employee1.getBirthDate(), employee2.getBirthDate());
        assertEquals(employee1.getHireDate(), employee2.getHireDate());
    }

    private List<EmployeeEntity> prepareSampleListOfEmployeeEntities() throws ParseException {
        List<EmployeeEntity> entities = new ArrayList<>();
        EmployeeEntity employee1 = new EmployeeEntity();
        employee1.setFirstName("Thang");
        employee1.setLastName("Le Quoc");
        employee1.setGender(Gender.F);
        employee1.setBirthDate(dateFormat.parse("08-08-1995"));
        entities.add(employee1);

        EmployeeEntity employee2 = new EmployeeEntity();
        employee2.setFirstName("Christian");
        employee2.setLastName("Fritz");
        employee2.setGender(Gender.M);
        employee2.setBirthDate(dateFormat.parse("03-06-1982"));
        entities.add(employee2);

        return entities;
    }

    private List<EmployeeDto> prepareSampleListOfEmployeeDto() throws ParseException {
        EmployeeDto expectedEmployee1 = new EmployeeDto();
        expectedEmployee1.setFirstName("Thang");
        expectedEmployee1.setLastName("Le Quoc");
        expectedEmployee1.setGender(Gender.F);
        expectedEmployee1.setBirthDate(dateFormat.parse("08-08-1995"));

        EmployeeDto expectedEmployee2 = new EmployeeDto();
        expectedEmployee2.setFirstName("Christian");
        expectedEmployee2.setLastName("Fritz");
        expectedEmployee2.setGender(Gender.M);
        expectedEmployee2.setBirthDate(dateFormat.parse("03-06-1982"));

        return Arrays.asList(expectedEmployee1, expectedEmployee2);
    }

}
