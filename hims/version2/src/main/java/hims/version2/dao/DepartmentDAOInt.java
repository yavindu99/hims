package hims.version2.dao;

import hims.version2.entitry.Department;

public interface DepartmentDAOInt {

    Department getByDepartmentCode(String departmentCode);
    Department getClinicByDepartmentCode(String departmentCode);

}
