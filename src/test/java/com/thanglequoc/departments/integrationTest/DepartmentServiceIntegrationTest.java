package com.thanglequoc.departments.integrationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.thanglequoc.H2DatasourceContextProfileConfiguration;
import com.thanglequoc.departments.DepartmentEntity;
import com.thanglequoc.departments.DepartmentService;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        H2DatasourceContextProfileConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class DepartmentServiceIntegrationTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    @Sql("classpath:/com/thanglequoc/departments/test/test_departments.sql")
    public void testGetDepartmentEntityById() {
        String customerDeptId = "d001";
        String customerDeptName = "Customer Service";
        DepartmentEntity customerDept = departmentService.getDepartmentEntityById(customerDeptId);
        assertNotNull(customerDept);
        assertEquals(customerDeptName, customerDept.getName());
    }
}
