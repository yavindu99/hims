package hims.admical.administrative.department.departmentType;


import hims.common.CustomResponseMainBody;

public interface DepartmentTypeServiceInt {

    CustomResponseMainBody add(DepartmentType departmentType);
    CustomResponseMainBody getByDepartmentTypeId(int id);
    CustomResponseMainBody getList();
    CustomResponseMainBody edit(DepartmentType departmentType);
    CustomResponseMainBody deleteByDepartmentTypeId(int id);
}
