package hims.version2.repository;

import hims.version2.entitry.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    Department findDepartmentByDepartmentCodeAndDepartmentType(String departmentCode, String departmentType);


}
