package hims.admical.administrative.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositoryInt extends JpaRepository<Department,Integer> {

    Department findDepartmentByDepartmentName(String departmentName);

}

