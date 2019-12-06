package hims.admical.administrative.department;

import java.util.List;

public interface DepartmentDAOInt {

    Department addNewDepartment(Department department);
    List<Department> getAllDepartments();
    Department updateDepartment(Department department);
    Department deleteDepartmentByDepartmentId(int departmentId);
    Department getDepartmentByDeprtmentName(String departmentName);

}
