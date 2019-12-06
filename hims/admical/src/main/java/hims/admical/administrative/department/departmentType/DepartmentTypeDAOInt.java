package hims.admical.administrative.department.departmentType;


import hims.common.CustomException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public interface DepartmentTypeDAOInt {

    DepartmentType add(DepartmentType departmentType) throws CustomException;
    List<DepartmentType> getList();
    DepartmentType getByDepartmentTypeId(int id);
    DepartmentType edit(DepartmentType departmentType) throws CustomException;
    void deleteByDepartmentTypeId(int id) throws CustomException;

}
