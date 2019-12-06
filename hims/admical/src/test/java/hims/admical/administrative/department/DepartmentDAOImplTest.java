package hims.admical.administrative.department;

import hims.admical.administrative.department.departmentType.DepartmentTypeDAOInt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentDAOImplTest {

    @Autowired
    private DepartmentDAOInt dao;

    @Autowired
    private DepartmentTypeDAOInt daoT;

    @MockBean
    private DepartmentRepositoryInt repo;

    @Test
    public void getDepartmentByDepartmentName(){

        Department department = new Department();
        department.setDepartmentCode("DEPA");
        department.setDepartmentName("Department");

        Mockito.when(repo.findDepartmentByDepartmentName("Department")).thenReturn(department);

        assertEquals(department, repo.findDepartmentByDepartmentName("Department"));


    }
}